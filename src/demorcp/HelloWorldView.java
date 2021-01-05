package demorcp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class HelloWorldView extends ViewPart {
	private Text text;
	private Text text_1;
	public HelloWorldView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		parent.setLayout(null);
		
		Label lblUsernam = new Label(parent, SWT.NONE);
		lblUsernam.setBounds(27, 60, 61, 17);
		lblUsernam.setText("username");
		
		Label lblPassword = new Label(parent, SWT.NONE);
		lblPassword.setBounds(27, 132, 61, 17);
		lblPassword.setText("password");
		
		text = new Text(parent, SWT.BORDER);
		text.setBounds(101, 54, 160, 23);
		
		text_1 = new Text(parent, SWT.BORDER);
		text_1.setBounds(101, 126, 160, 23);
		
		Button btnSubmit = new Button(parent, SWT.NONE);
		btnSubmit.setBounds(40, 195, 80, 27);
		btnSubmit.setText("Submit");
		
		Button btnCancel = new Button(parent, SWT.NONE);
		btnCancel.setBounds(161, 195, 80, 27);
		btnCancel.setText("Cancel");

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
