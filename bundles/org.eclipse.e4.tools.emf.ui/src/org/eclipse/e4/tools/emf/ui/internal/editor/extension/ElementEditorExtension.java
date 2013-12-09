/*******************************************************************************
 * Copyright (c) 2013 MEDEVIT, FHV and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marco Descher <marco@descher.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.e4.tools.emf.ui.internal.editor.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.e4.tools.emf.ui.common.AbstractElementEditorContribution;

public class ElementEditorExtension {
	private static HashMap<Class<?>, List<AbstractElementEditorContribution>> contributions = new HashMap<Class<?>, List<AbstractElementEditorContribution>>();

	static {
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		IExtensionPoint extPoint = registry.getExtensionPoint("org.eclipse.e4.tools.emf.ui.elementEditorTab"); //$NON-NLS-1$
		IConfigurationElement[] elements = extPoint.getConfigurationElements();

		if (elements.length > 0) {
			for (IConfigurationElement e : elements) {
				final IConfigurationElement le = e;
				try {
					AbstractElementEditorContribution contribution = (AbstractElementEditorContribution) le.createExecutableExtension("contribution"); //$NON-NLS-1$
					Class<?> contribElem = contribution.getContributableTo();

					if (!contributions.containsKey(contribElem)) {
						contributions.put(contribElem, new ArrayList<AbstractElementEditorContribution>());
					}

					List<AbstractElementEditorContribution> res = contributions.get(contribElem);

					res.add(contribution);
					//System.out.println("Adding contribution for " + contribElem + " from " + contribution.getClass().getName()); //$NON-NLS-1$ //$NON-NLS-2$

				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public static List<AbstractElementEditorContribution> getContributions(Class<?> clazz) {
		List<AbstractElementEditorContribution> ret = new ArrayList<AbstractElementEditorContribution>();
		for (Class<?> clasz : contributions.keySet()) {
			if (clasz.isAssignableFrom(clazz))
				ret.addAll(contributions.get(clasz));
		}
		return ret;
	}

}
