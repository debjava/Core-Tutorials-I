

package com.rrs.corona.solutionsacceleratorstudio;
/**
 * @author Debadatta Mishra
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class DatabasePerspective implements IPerspectiveFactory
{
	
	public void createInitialLayout(IPageLayout layout) 
	{
		layout.setFixed( false );
		layout.addStandaloneView( "com.rrs.corona.solutionsacceleratorstudio.plugin.DatabaseViewer", true, IPageLayout.LEFT, 1.0f, layout.getEditorArea() );
	}
	
}
