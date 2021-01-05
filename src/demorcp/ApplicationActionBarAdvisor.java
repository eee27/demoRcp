package demorcp;

import javax.swing.JPopupMenu.Separator;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import demorcp.actions.HttpAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private IWorkbenchAction newAction;
	private IWorkbenchAction saveProjectAction;
	private IWorkbenchAction saveAllAction;
	private IWorkbenchAction newWindowAction;
	
	private IContributionItem iContributionItem;
	
	private IWorkbenchAction importAction;
	private IWorkbenchAction exportAction;
	
	
	
	private IWorkbenchAction httpAction;
	
	

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	@Override
	protected void makeActions(IWorkbenchWindow window) {
		exitAction=ActionFactory.QUIT.create(window);
		register(exitAction);
		
		aboutAction=ActionFactory.ABOUT.create(window);
		register(aboutAction);
		
		newAction = ActionFactory.NEW.create(window);
		register(newAction);
		
		saveProjectAction=ActionFactory.SAVE.create(window);
		saveAllAction=ActionFactory.SAVE_ALL.create(window);
		this.getActionBarConfigurer().registerGlobalAction(saveProjectAction);
		this.getActionBarConfigurer().registerGlobalAction(saveAllAction);
		
		newWindowAction=ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(newWindowAction);
		
		iContributionItem=ContributionItemFactory.VIEWS_SHORTLIST.create(window);
		
		importAction=ActionFactory.IMPORT.create(window);
		exportAction=ActionFactory.EXPORT.create(window);
		register(importAction);
		register(exportAction);
		
		httpAction=new HttpAction(window);
		httpAction.setText("Http Test");
		httpAction.setId(HttpAction.class.toString());
		register(httpAction);
	}
	
	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenuManager=new MenuManager("&File",IWorkbenchActionConstants.M_FILE);
		fileMenuManager.add(newAction);
		fileMenuManager.add(new org.eclipse.jface.action.Separator());
		fileMenuManager.add(importAction);
		fileMenuManager.add(exportAction);
		

		MenuManager windoMenuManager=new MenuManager("&Window",IWorkbenchActionConstants.M_WINDOW);
		windoMenuManager.add(newWindowAction);
		
		MenuManager showViewManager=new MenuManager("&Garden");
		showViewManager.add(iContributionItem);
		showViewManager.add(new org.eclipse.jface.action.Separator());
		
		showViewManager.add(httpAction);
		
		windoMenuManager.add(showViewManager);
		
		
		MenuManager helpMenuManager=new MenuManager("&Help",IWorkbenchActionConstants.M_HELP);
		helpMenuManager.add(aboutAction);
		helpMenuManager.add(exitAction);
		
		menuBar.add(fileMenuManager);
		menuBar.add(windoMenuManager);
		menuBar.add(showViewManager);
		menuBar.add(helpMenuManager);
	}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		ToolBarManager barManager=new ToolBarManager();
		barManager.add(saveProjectAction);
		barManager.add(saveAllAction);
		coolBar.add(barManager);
	}

}

