package demorcp.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class HttpAction extends Action implements IWorkbenchAction {
	private IWorkbenchWindow workbenchWindow;
	
	public HttpAction(IWorkbenchWindow workbenchWindow){
		if(workbenchWindow==null) {
			throw new IllegalArgumentException();
		}
		this.workbenchWindow=workbenchWindow;
	}
	
	
	@Override
	public void run() {
		System.out.println("XXXXXXXXXXXXXX11111111111111111111");
	}
	
	

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
