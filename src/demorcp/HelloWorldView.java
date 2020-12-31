package demorcp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class HelloWorldView extends ViewPart {
	
	Label lbHelloWorld;

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(null);
		lbHelloWorld=new Label(parent, SWT.NONE);
		lbHelloWorld.setText("Hello World");
		lbHelloWorld.setBounds(80,60,100,100);

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
