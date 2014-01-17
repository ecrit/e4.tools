/*******************************************************************************
 * Copyright (c) 2010 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl <tom.schindl@bestsolution.at> - initial API and implementation
 ******************************************************************************/
package org.eclipse.e4.tools.emf.ui.internal.common.component;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.e4.tools.emf.ui.internal.ResourceProvider;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class DialogEditor extends WindowEditor {

	@Override
	public Image getImage(Object element, Display display) {
		if (element instanceof MUIElement) {
			MUIElement uiElement = (MUIElement) element;
			if (uiElement.isToBeRendered() && uiElement.isVisible()) {
				return createImage(ResourceProvider.IMG_Dialog);
			} else {
				return createImage(ResourceProvider.IMG_Tbr_Dialog);
			}
		}

		return null;
	}

	@Override
	public String getLabel(Object element) {
		return Messages.DialogEditor_Label;
	}

	@Override
	public List<Action> getActions(Object element) {
		List<Action> actions = new ArrayList<Action>();

		MDialog dialog = (MDialog) element;
		if (dialog.getMainMenu() == null) {
			actions.add(getActionAddMainMenu());
		}

		return actions;
	}
}