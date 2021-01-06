package demorcp;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import demorcp.views.EditorView;
import demorcp.views.HelloWorldView;

public class Perspective implements IPerspectiveFactory {
	public static final String ID="demorcp.Perspective";
	

	@Override	
	public void createInitialLayout(IPageLayout layout) {
		
		String editAreaString=layout.getEditorArea();
		layout.addView(HelloWorldView.ID, IPageLayout.LEFT, 0.4f, editAreaString);
		layout.addView(EditorView.ID, IPageLayout.LEFT, 0.6f, editAreaString);
		
		//layout.getViewLayout(HelloWorldView.ID).setCloseable(false);
		//layout.getViewLayout(HelloWorldView.ID).setMoveable(false);
		
		
	}
}
