
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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

import com.rrs.corona.Sas.DataSourceList;
import com.rrs.corona.Sas.Sas;

public class DeleteDataSourceDialog extends TitleAreaDialog 
{
	transient private Button okButton = null;
	transient private Button cancelButton =  null;
	Text commentText;
	boolean testFlag = false;
	transient private Combo dsName     = null;
	transient private Text urlText     = null;		
	transient private Text userText = null;
	transient private Text passwordText     = null;
	public String username = null ;
	public String url = null ;
	public String password = null ;
	Button addBtn ;
	
	public DeleteDataSourceDialog(Shell parentShell) 
	{
		super(parentShell);	
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage("Select Data Source to delete from the list");
	}
	
	public Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("Delete Data Source");   
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
					boolean flag = MessageDialog.openConfirm(parent.getShell(),"Warning","Do u want to delete");
					if(flag == true)
					{
						DsDelete dsdelete = new DsDelete();
						String tempDsName = dsName.getText();
						dsdelete.deleteDataSource(tempDsName);
						parent.getShell().close();
					}
					else
					{
						// do nothing
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
	
	public void checkForText(  )
	{
		if ( ( commentText.getText().toString().length() != 0 ) )
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
		GridData gdData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		createLabel(firstGroup,"Select Data Source ",gridData);
		createDataSourceCombo(firstGroup,gdData1);
		createLabel(firstGroup,"Database URL",gridData);
		createURLText(firstGroup,gdData1);
		createLabel(firstGroup,"User Name",gridData);
		createUserText(firstGroup,gdData1);
		createLabel(firstGroup,"Password",gridData);
		createPasswordText(firstGroup,gdData1);
		firstGroup.setBounds(25, 25, 380, 120);
	}
	
	public void createLabel(Composite firstGroup,String text,GridData gridData)
	{
		Label labelName = new Label(firstGroup, SWT.LEFT);	// It should be initialized first	
		labelName.setText(text); // Label Name of the test field to be displayed				
		labelName.setLayoutData(gridData); 
	}
	
	public void createDataSourceCombo(Composite firstGroup,GridData gdData1)
	{
		dsName = new Combo(firstGroup, SWT.BORDER | SWT.READ_ONLY); // Creates a Combo box
		gdData1.horizontalSpan = 2;
		dsName.setLayoutData(gdData1);
		DsReader dsreader = new DsReader();
		Sas sas = dsreader.getSas();
		List dataSourceList =  sas.getDataSource();
		for(int i=0;i<dataSourceList.size();i++)
		{
			DataSourceList dataSource = (DataSourceList) dataSourceList.get(i);
			dsName.add((String)dataSource.getDataSourceName());
			username =  dataSource.getUserName();
			url = dataSource.getURL();
			password = dataSource.getPassword();
		}	
		dsName.addModifyListener( new ModifyListener() // implementation of Listener
				{
			public void modifyText(ModifyEvent e) 
			{
				userText.setText(username);
				urlText.setText(url);
				passwordText.setText(password);
				okButton.setEnabled(true); // if some characters are entered in the text field, OK btn will be enabled.						
			}
			
				});		
	}
	
	public void createURLText(Composite firstGroup,GridData gdData1)
	{
		urlText = new Text(firstGroup, SWT.BORDER|SWT.READ_ONLY);
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gdData1.horizontalSpan = 2;		
		urlText.setLayoutData(gdData1);
	}
	
	public void createUserText(Composite firstGroup,GridData gdData1)
	{
		userText = new Text(firstGroup, SWT.BORDER|SWT.READ_ONLY);
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gdData1.horizontalSpan = 2;	
		gdData1.horizontalSpan = 2;
		userText.setLayoutData(gdData1);
	}
	
	public void createPasswordText(Composite firstGroup,GridData gdData1)
	{
		passwordText = new Text(firstGroup, SWT.BORDER|SWT.READ_ONLY);
		passwordText.setEchoChar('*');
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gdData1.horizontalSpan = 2;		
		passwordText.setLayoutData(gdData1);
	}
	
}



