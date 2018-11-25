
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RenameDataSourceDialog extends TitleAreaDialog
{
	transient private Button okButton = null;
	transient private Button cancelButton =  null;
	Text commentText;
	boolean testFlag = false;
	transient private Combo previousDsName     = null; // name of the Combo field	
	transient private Text  newDsNameText     = null;		
	Button addBtn ;
	ArrayList dsNames = new ArrayList();
	
	public RenameDataSourceDialog(Shell parentShell) 
	{
		super(parentShell);		
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage("Select Data Source to rename");
	}
	
	public Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("Rename Data Source");
		
		try
		{		
			createWorkArea(parent);
			return parent;
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
			okButton = createButton(parent,999,"OK",true);
			okButton.setEnabled(false);			
			cancelButton = createButton(parent,999,"Cancel",true);
			
			okButton.addSelectionListener(new SelectionAdapter()
					{
				public void widgetSelected(SelectionEvent e) 
				{
					// write logic here
					String oldDsName = previousDsName.getText();
					String newDsName = newDsNameText.getText();
					DsRename dsrename = new DsRename();
					if(!validateRenameTextField())
					{
						MessageDialog.openInformation(parent.getShell(),"Message","Please enter the dataSource name to rename");
						
					}
					else if(!validateDsComboBox())
					{
						MessageDialog.openInformation(parent.getShell(),"Message","Please select a dataSource name to rename");
					}
					else
					{
						dsrename.renameDataSourcename(oldDsName,newDsName);
						parent.getShell().close();
					}
					
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
	
	public void setListeners(  )
	{
		testFlag =false;
		commentText.addModifyListener( new ModifyListener(  )
				{
			public void modifyText( ModifyEvent event )
			{
				checkForText(  );
			}
				} );
		testFlag = true;		
	}
	
	/**
	 *It disables the ok
	 * button unless the text boxes are filled.
	 *
	 */
	public void checkForText(  )
	{
		if ( ( commentText.getText(  ).toString(  ).length(  ) != 0 ) )
		{
			okButton.setEnabled( true );
		}
		else
		{
			okButton.setEnabled( false );
		}
	}	
	
	private void createWorkArea(Composite parent)
	{
		Composite area = new Composite(parent, SWT.NULL);				
		Composite     firstGroup = new Composite(area, SWT.NONE); // 1st group
		firstGroup.setLayout(new GridLayout(3, true)); // lay out
		GridData gridData = new GridData(); // to show in a grid	
		createLabel(firstGroup,"Select Data Source",gridData);		
		createPrevCombo(firstGroup,gridData);
		createLabel(firstGroup,"New Data Source",gridData);
		createDsText(firstGroup,gridData);		
		//firstGroup.setBounds(10, 20, 480, 150);
		firstGroup.setBounds(25, 25, 380, 120);
	}
	
	public void createPrevCombo(Composite firstGroup,GridData gridData1)
	{
		previousDsName = new Combo(firstGroup, SWT.BORDER | SWT.READ_ONLY); // Creates a Combo box
		previousDsName.addModifyListener( new ModifyListener() // implementation of Listener
				{
			public void modifyText(ModifyEvent e) 
			{
				okButton.setEnabled(true); // if some characters are entered in the text field, OK btn will be enabled.
				
				
			}
				});
		
		gridData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		gridData1.horizontalSpan = 2;
		previousDsName.setLayoutData(gridData1);
		
		DsReader dsreader = new DsReader();
		dsNames = dsreader.getDataSourceNames();
		for(int i=0;i<dsNames.size();i++)
		{
			previousDsName.add((String)dsNames.get(i));
		}
	}
	
	public void createDsText(Composite firstGroup,GridData gridData1)
	{
		newDsNameText = new Text(firstGroup, SWT.BORDER);
		gridData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gridData1.horizontalSpan = 2;		
		newDsNameText.setLayoutData(gridData1);
		validateNewDsNameText(newDsNameText);
	}
	
	public void createLabel(Composite firstGroup, String text,GridData gridData)
	{
		Label previousDsLabelName = new Label(firstGroup, SWT.LEFT);	// It should be initialized first, First Label	
		previousDsLabelName.setText(text); // Label Name of the test field to be displayed	
		//previousDsLabelName.setSize(180,50);
		previousDsLabelName.setLayoutData(gridData); 	
	}
	
	public void validateNewDsNameText(final Text newDsNameText)
	{
		newDsNameText.addModifyListener( new ModifyListener() // implementation of Listener
				{
			public void modifyText(ModifyEvent e) 
			{
				if(newDsNameText.getText() == "" || newDsNameText.getText() == null || newDsNameText.getText().contains(" "))
				{
					okButton.setEnabled(false);
				}
				else
				{
					okButton.setEnabled(true); // if some characters are entered in the text field, OK btn will be enabled.
				}
			}
			
				});
	}
	
	public boolean validateRenameTextField()
	{
		boolean textFieldFlag = false;
		String tmp_textField = newDsNameText.getText();
		if(tmp_textField == "" || tmp_textField == null || tmp_textField.contains(" "))
		{
			textFieldFlag = false;
		}
		else
		{
			textFieldFlag = true;
		}
		
		return textFieldFlag;
	}
	
	public boolean validateDsComboBox()
	{
		boolean textFlag = false;
		String tmp_dsField = previousDsName.getText();
		if(tmp_dsField == "" || tmp_dsField == null || tmp_dsField.contains(" "))
		{
			textFlag = false;
		}
		else
		{
			textFlag = true;
		}
		
		return textFlag;
	}
	
}
