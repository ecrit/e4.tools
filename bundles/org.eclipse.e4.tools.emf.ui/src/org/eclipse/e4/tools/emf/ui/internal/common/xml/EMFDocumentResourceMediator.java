package org.eclipse.e4.tools.emf.ui.internal.common.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.e4.tools.emf.ui.common.IModelResource;
import org.eclipse.e4.ui.internal.workbench.E4XMIResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.xml.sax.InputSource;

public class EMFDocumentResourceMediator {
	private IModelResource modelResource;
	private Document document;
	private boolean updateFromEMF;
	private List<Diagnostic> errorList = new ArrayList<Diagnostic>();
	private Runnable documentValidationChanged;

	public EMFDocumentResourceMediator(final IModelResource modelResource) {
		this.modelResource = modelResource;
		this.document = new Document();
		this.document.addDocumentListener(new IDocumentListener() {

			@Override
			public void documentChanged(DocumentEvent event) {
				if (updateFromEMF) {
					return;
				}

				String doc = document.get();
				E4XMIResource res = new E4XMIResource();
				try {
					res.load(new InputSource(new StringReader(doc)), null);
					modelResource.replaceRoot(res.getContents().get(0));
					errorList.clear();
					if (documentValidationChanged != null) {
						documentValidationChanged.run();
					}
				} catch (IOException e) {
					errorList = res.getErrors();
					if (documentValidationChanged != null) {
						documentValidationChanged.run();
					}

				}
			}

			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {

			}
		});
		updateFromEMF();
	}

	public void setValidationChangedCallback(Runnable runnable) {
		documentValidationChanged = runnable;
	}

	public List<Diagnostic> getErrorList() {
		return Collections.unmodifiableList(errorList);
	}

	public void updateFromEMF() {
		try {
			updateFromEMF = true;
			this.document.set(toXMI((EObject) modelResource.getRoot().get(0)));
		} finally {
			updateFromEMF = false;
		}
	}

	public Document getDocument() {
		return document;
	}

	private String toXMI(EObject root) {
		E4XMIResource resource = (E4XMIResource) root.eResource();
		// resource.getContents().add(EcoreUtil.copy(root));
		StringWriter writer = new StringWriter();
		try {
			resource.save(writer, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer.toString();
	}
}
