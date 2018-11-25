
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ManageTablesDialog extends TitleAreaDialog
{
	transient private Button okButton = null;
	transient private Button cancelButton =  null;
	Text commentText;
	boolean testFlag = false;
	Button addBtn ;
	
	public ManageTablesDialog(Shell parentShell) 
	{
		super(parentShell);
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		//setMessage("Manage Tables");
	}
	
	public Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("Manage Tables");
		Composite area = new Composite(parent, SWT.NULL);   
		try
		{		
			Group group1 = new Group(area,SWT.NONE);
			createWorkArea(parent);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return parent;
	}
	
	protected void createButtonsForButtonBar(final Composite parent)
	{
		testFlag =false;
		
		try
		{
			okButton = createButton(parent,999,"Ok",true);
			okButton.setEnabled(false);			
			cancelButton = createButton(parent,999,"Cancel",true);
			okButton.addSelectionListener(new SelectionAdapter()
					{
				public void widgetSelected(SelectionEvent e) 
				{
					
				}
				
					});
			cancelButton.addSelectionListener(new SelectionAdapter()
					{
				
				public void widgetSelected(SelectionEvent e) 
				{
					parent.getShell().close();
				}		
				
					});
			testFlag = true;
		}catch(Exception e)
		{
			testFlag = false;
			e.printStackTrace();
		}
	}
	
	private void createWorkArea(Composite parent)
	{
		Composite area = new Composite(parent, SWT.NULL);		
		Group firstGroup = new Group(area, SWT.NONE); // 1st group		
		firstGroup.setText("Tables");
		GridLayout newGrid = new GridLayout(3,true);
		newGrid.verticalSpacing = 2;		
		firstGroup.setLayout(newGrid); // lay out
		GridData gridData = new GridData(); // to show in a grid
		createLabel(firstGroup,"Total Tables List",gridData);
		createLabel(firstGroup," ",gridData);
		createLabel(firstGroup,"Selected Tables List",gridData);
		createTotalDsList(firstGroup,gridData);
		GridData butonGrid = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		createFirstButton(firstGroup,butonGrid);
		createSelectedDsList(firstGroup,gridData);		
		createSecondButton(firstGroup,butonGrid);
		firstGroup.setBounds(10, 20, 480, 150);
	}
	
	public void createLabel(Group firstGroup,String text,GridData gridData)
	{
		Label firstLabel = new Label(firstGroup, SWT.LEFT_TO_RIGHT);	// It should be initialized first, First Label	
		firstLabel.setText(text); // Label Name of the test field to be displayed		
		firstLabel.setLayoutData(gridData); 		
	}
	
	public void createTotalDsList(Group firstGroup,GridData gridData)
	{
		List dsList = new List(firstGroup,SWT.BORDER); // for total no of datasource list
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.verticalSpan = 2;
		dsList.setLayoutData(gridData);
	}
	
	public void createSelectedDsList(Group firstGroup,GridData gridData)
	{
		List selectedDsList = new List(firstGroup,SWT.BORDER); // for selected Datasource List
		gridData = new GridData(GridData.FILL_BOTH);
		gridData.verticalSpan = 2;
		selectedDsList.setLayoutData(gridData);	
	}
	
	public void createFirstButton(Group firstGroup,GridData butonGrid)
	{
		Button rightArrowButton = new Button(firstGroup,SWT.PUSH);
		rightArrowButton.setText(">>");
		rightArrowButton.setLayoutData(butonGrid);
	}
	
	public void createSecondButton(Group firstGroup,GridData butonGrid)
	{
		Button leftArrowButton = new Button(firstGroup,SWT.PUSH);
		leftArrowButton.setText("<<");
		leftArrowButton.setLayoutData(butonGrid);
	}
	
	
}
