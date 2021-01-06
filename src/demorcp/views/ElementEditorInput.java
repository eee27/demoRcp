package demorcp.views;

import javax.swing.text.Element;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ElementEditorInput implements IEditorInput {
	private Element element;
	
	public ElementEditorInput(Element element) {
		// TODO Auto-generated constructor stub
		this.element=element;
	}
	
	public Element getElement() {
		return element;
	}
	
	

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return element.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return element.getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj)) {return true;}
		if(!(obj instanceof ElementEditorInput)) {return false;}
		ElementEditorInput otherEditorInput=(ElementEditorInput)obj;
		return this.element.getName().equalsIgnoreCase(otherEditorInput.getName());
	}

}
