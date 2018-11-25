
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class ManageDataSource extends Action implements IWorkbenchWindowActionDelegate 
{
	static IWorkbenchWindow window = null;
	
	public void dispose() 
	{
		
	}
	
	public void init(IWorkbenchWindow window) 
	{
		this.window = window;	
	}
	
	public void run(IAction action) 
	{
		ManageDataSourceDialog manageDialog = new ManageDataSourceDialog(window.getShell());
		manageDialog.open();
	}
	
	public void selectionChanged(IAction action, ISelection selection) 
	{
		
	}
	
}
