
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import com.rrs.corona.common.CommonConstants;
//import com.rrs.corona.solutionsacceleratorstudio.SASConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Listener;

import com.rrs.corona.solutionsacceleratorstudio.datasource.DatabaseManager;
import com.rrs.corona.solutionsacceleratorstudio.datasource.DbmsInfo;

public class CreateDataSourceDialog extends TitleAreaDialog  // implements Listener
{	
	transient private Button okButton = null;
	transient private Button cancelButton =  null;
	Text commentText;
	boolean testFlag = false;
	transient private Text dsName = null; // name of the dataSource text field	
	transient private Text urlText = null;		
	transient private Text userText = null;
	transient private Text passwordText  = null;
	boolean checkConnection = false;
	Connection connection = null;
	Button testButton = null;
	Button addBtn ;
	boolean duplicateDsName = false ;
	DatabaseManager dbManager = new DatabaseManager();
	//String dataSourceFileName = SASConstants.DATASOURCE_FILENAME;
	String dataSourceFileName = "D:/main/dataSource/dsInfo.xml";
	
	public CreateDataSourceDialog(Shell parentShell) 
	{
		super(parentShell);
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage("Create a Data Source by entering the database details ");
	}
	
	public Control createDialogArea(Composite parent)
	{   
		try
		{		
			parent.getShell().setText("Create Data Source");			
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
			testButton = createButton(parent,555,"Test Connection... ",false);
			testButton.setToolTipText("click here to test the database connection");
			testButton.setEnabled(false);
			okButton = createButton(parent,999,"OK",true);
			okButton.setEnabled(false);			
			cancelButton = createButton(parent,999,"Cancel",true);	
			
			testButton.addSelectionListener(new SelectionAdapter() // test button action
					{
				public void widgetSelected(SelectionEvent e) 
				{
					//checkConnection(parent); // for checking successful database connection
				}
					});
			
			okButton.addSelectionListener(new SelectionAdapter() 
					{
				public void widgetSelected(SelectionEvent e) 
				{
					// action logic for okButton
					duplicateDsName = checkForDuplicateDsName(parent); // checking for duplicate datasource name if exists
					if(duplicateDsName == true)
					{
						// do nothing
					}
					
					else if(!validateOtherTextFields())
					{
						MessageDialog.openInformation(parent.getShell(),"Message","Please enter the valid information");
					}
					else
					{
						//populateData(parent); // populating the all database information details to an xml file.
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
		}
		catch(Exception e)
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
	
	public void checkForText()// If text field is blank, okButton will be disabled
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
		GridData gdData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		firstGroup.setLayout(new GridLayout(3, true)); // lay out
		GridData gridData = new GridData(); // to show in a grid		
		createLabel(firstGroup,"Data Source Name",gridData); // method create a lebel
		createDataSourceText(firstGroup,gdData1);	// method to create a text
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
	
	public void createDataSourceText(Composite firstGroup,GridData gdData1)
	{
		dsName = new Text(firstGroup, SWT.BORDER); // Creates a text box	
		validateDataSourceText(dsName);
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		gdData1.horizontalSpan = 2;
		dsName.setLayoutData(gdData1);		
	}
	
	public void createURLText(Composite firstGroup,GridData gdData1)
	{
		urlText = new Text(firstGroup, SWT.BORDER);
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gdData1.horizontalSpan = 2;		
		urlText.setLayoutData(gdData1);
		validateURLText(urlText);
	}
	
	public void createUserText(Composite firstGroup,GridData gdData1)
	{
		userText = new Text(firstGroup, SWT.BORDER);
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gdData1.horizontalSpan = 2;		
		userText.setLayoutData(gdData1);
	}
	
	public void createPasswordText(Composite firstGroup,GridData gdData1)
	{
		passwordText = new Text(firstGroup, SWT.BORDER);
		passwordText.setEchoChar('*');
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);		
		gdData1.horizontalSpan = 2;		
		passwordText.setLayoutData(gdData1);
	}
	
	public void checkConnection(Composite parent)
	{
		DbmsInfo dbInfo = new DbmsInfo();
		dbInfo.setDbUrl(urlText.getText().toString());
		dbInfo.setDbUser(userText.getText().toString());
		dbInfo.setDbPassword(passwordText.getText().toString());
		try 
		{
			connection = dbManager.getDatabaseConnection(dbInfo);
			if(connection != null)
			{
				MessageDialog.openInformation(parent.getShell(),"Success","Test Connection Successful");
				dbManager.close(connection);
				connection = null;
			}
		} 
		catch (SQLException e1) 
		{
			MessageDialog.openError(parent.getShell(),"Warning","Test Connection Unsuccessful");
		}
	}
	
	public void displayDataSource(Composite parent)
	{
		DbmsInfo dbInfo = new DbmsInfo();
		dbInfo.setDbUrl(urlText.getText().toString());
		dbInfo.setDbUser(userText.getText().toString());
		dbInfo.setDbPassword(passwordText.getText().toString());
		try 
		{
			connection = dbManager.getDatabaseConnection(dbInfo);
		} catch (SQLException e1) 
		{
			MessageDialog.openError(parent.getShell(),"Warning","Connection Unsuccessful");
		}
		String dataname = dsName.getText().toString();
		IStructuredSelection select = (IStructuredSelection) DatabaseViewer.viewer.getSelection();
		TreeParent invisibleParent = (TreeParent)select.getFirstElement();
		TreeParent newdataSrc = new TreeParent(dataname);
		invisibleParent.addChild(newdataSrc);
		DatabaseViewer.viewer.refresh(invisibleParent,false);					
		parent.getShell().close();
	}
	
	public void validateURLText(final Text urlText) // validation for URLText field
	{
		urlText.addModifyListener( new ModifyListener() // implementation of Listener
				{
			public void modifyText(ModifyEvent e) 
			{
				if(urlText.getText() == "" || urlText.getText() == null || urlText.getText().contains(" "))
				{
					testButton.setEnabled(false);
				}
				else
				{
					testButton.setEnabled(true); // if some characters are entered in the text field, OK btn will be enabled.
				}
			}
				});
	}
	
	public void validateDataSourceText(final Text dsName)// validation for DataSourceField text
	{	
		dsName.addModifyListener( new ModifyListener() // implementation of Listener
				{
			public void modifyText(ModifyEvent e) 
			{
				if(dsName.getText() == "" || dsName.getText() == null || dsName.getText().contains(" "))
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
	
	public boolean validateOtherTextFields()// validations for other text fields
	{
		boolean fieldsFlag = false;
		String tmp_userText = userText.getText();
		String tmp_urlText = urlText.getText();
		if(tmp_userText == "" || tmp_userText == null || tmp_userText.contains(" ") || tmp_urlText == "" || tmp_urlText == null || tmp_urlText.contains(" "))
		{
			fieldsFlag = false;
		}
		else
		{
			fieldsFlag = true;
		}
		
		
		return fieldsFlag; 
	}
	
	public void populateData(Composite parent)// populate the required data into an xml file
	{
		DbmsInfo dbInfo = new DbmsInfo();
		dbInfo.setDataSourceName(dsName.getText().toString());
		dbInfo.setDbUrl(urlText.getText().toString());
		dbInfo.setDbUser(userText.getText().toString());
		dbInfo.setDbPassword(passwordText.getText().toString());
		DataWriter dataWriter = new DataWriter();
		
		try 
		{
			connection = dbManager.getDatabaseConnection(dbInfo);
		} 
		catch (SQLException e1) 
		{
			MessageDialog.openError(parent.getShell(),"Warning","Connection Unsuccessful");
		}
		File dbmsFile =  new File(dataSourceFileName);
		if(!dbmsFile.exists())
		{	
			dataWriter.writeToXmlFile(connection,dbInfo);
		}
		else
		{
			dataWriter.readAndwrite(connection,dbInfo); // first it will read and then append the contents to the existing xml file
		}
		parent.getShell().close();
	}
	
	public boolean checkForDuplicateDsName(Composite parent) // checking for duplicate data source name in the xml file
	{
		boolean validDs = false;
		final ArrayList dsNames = new DsReader().getDataSourceNames();
		for(int i=0;i<dsNames.size();i++)
		{
			String tempDsname = (String)dsNames.get(i);
			if(dsName.getText().equalsIgnoreCase(tempDsname))
			{
				setMessage("Data Source name already exists, give different name");
				dsName.setText("");
				dsName.setFocus();
				okButton.setEnabled(false);
				validDs = true ;
			}
			else
			{
				validDs = false;
			}
		}
		return validDs;
	}
	
}
