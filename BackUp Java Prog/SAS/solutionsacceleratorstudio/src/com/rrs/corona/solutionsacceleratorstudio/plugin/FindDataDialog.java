
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.util.ArrayList;
//import java.util.logging.Logger;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FindDataDialog extends TitleAreaDialog
{
	transient private Button okButton = null;
	transient private Button cancelButton =  null;
	Text commentText;
	boolean testFlag = false;
	transient private Text findText = null; // name of the text field	
	DsReader dataInfoReader = new DsReader();
	Button addBtn ;
	Button dsButton = null;
	Button tableButton = null;
	Button fieldButton = null;
	Button matchButton = null;
	Button matchWholewordButton = null;
	Button searchUpButton = null;
	String searchText = null;	
	boolean dataSourceFlag = false;
	boolean tableFlag = false;
	boolean fieldFlag = false;
	String testFindPath = null;
	ArrayList foundDataSourceNames = new ArrayList();
	ArrayList foundTableNames = new ArrayList();
	ArrayList foundFieldNames = new ArrayList();
	
	//Logger logger = Logger.getLogger("FindDataDilog.class");
	
	public FindDataDialog(Shell parentShell) 
	{
		super(parentShell);
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage("Enter the details to find");
	}
	
	public Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("Find ");   
		
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
					checkForAllCasesInFind(parent);	
					// It contains the business logic for FindDilog
					parent.getShell().close();					
				} // end of widget				
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
	
	public void setListeners()
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
		GridData gridData = new GridData();
		createLabel(firstGroup,"Find",gdData1);
		findDataText(firstGroup,gdData1);	
		createDataSourceButton(firstGroup,gdData1);// For Data Source
		createTableButton(firstGroup,gdData1);// For Table
		createFieldButton(firstGroup,gdData1);//For Field
		createMatchCaseButton(firstGroup,gdData1);//For Match case
		createLabel(firstGroup," ",gridData);// empty label
		createLabel(firstGroup," ",gridData); // empty label
		createMatchWholeWordButton(firstGroup,gdData1);//For Match whole word
		createLabel(firstGroup," ",gridData);// empty label
		createLabel(firstGroup," ",gridData); // empty label
		createSearchUpButton(firstGroup,gdData1);// For Search Up
		firstGroup.setBounds(25, 25, 380, 120);
	}
	
	public void createLabel(Composite firstGroup,String text,GridData gridData)
	{
		Label labelName = new Label(firstGroup, SWT.LEFT);	// It should be initialized first	
		labelName.setText(text); // Label Name of the test field to be displayed	
		labelName.setLayoutData(gridData); 
	}
	
	public void findDataText(Composite firstGroup,GridData gdData1)
	{
		findText = new Text(firstGroup, SWT.BORDER); // Creates a text box	
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		gdData1.horizontalSpan = 2;
		findText.setLayoutData(gdData1);		
		validateFindDataText(findText);
	}
	
	public void createDataSourceButton(Composite firstGroup,GridData gdData1)
	{
		dsButton = new Button(firstGroup,SWT.RADIO);
		dsButton.setText("Data Souce");
		dsButton.setLayoutData(gdData1);
		
		dsButton.addSelectionListener(new SelectionAdapter()
				{
			public void widgetSelected(SelectionEvent e) 
			{
				searchText = findText.getText();  
			}
				});
	}
	
	public void createTableButton(Composite firstGroup,GridData gdData1)
	{
		tableButton = new Button(firstGroup,SWT.RADIO);
		tableButton.setText("Table");
		tableButton.setLayoutData(gdData1);
		
		tableButton.addSelectionListener(new SelectionAdapter()
				{
			public void widgetSelected(SelectionEvent e) 
			{
				// action logic for button
				
				searchText = findText.getText();  
			}
				});
	}
	
	public void createFieldButton(Composite firstGroup,GridData gdData1)
	{
		fieldButton = new Button(firstGroup,SWT.RADIO);
		fieldButton.setText("Field");
		fieldButton.setLayoutData(gdData1);
	}
	
	public void createMatchCaseButton(Composite firstGroup,GridData gdData1)
	{
		matchButton = new Button(firstGroup,SWT.CHECK);
		matchButton.setText("Match Case");
		matchButton.setLayoutData(gdData1);
		
		matchButton.addSelectionListener(new SelectionAdapter()
				{
			public void widgetSelected(SelectionEvent e) 
			{
				// action logic for button				
				searchText = findText.getText();  
			}
				});
	}
	
	public void createMatchWholeWordButton(Composite firstGroup,GridData gdData1)
	{
		matchWholewordButton = new Button(firstGroup,SWT.CHECK);
		matchWholewordButton.setText("Match whole word");
		matchWholewordButton.setLayoutData(gdData1);
	}
	
	public void createSearchUpButton(Composite firstGroup,GridData gdData1)
	{
		searchUpButton = new Button(firstGroup,SWT.CHECK);
		searchUpButton.setText("Search up");
		searchUpButton.setLayoutData(gdData1);
	}
	
	public void validateFindDataText(final Text dsName) // for validating findText field
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
	
	public boolean checkForDsWithoutCase(String textToFind)
	{
		ArrayList ds_name = new DsReader().getDataSourceNames();
		for(int i=0;i<ds_name.size();i++)
		{
			String temp_dsName = (String)ds_name.get(i);
			if(textToFind.equalsIgnoreCase(temp_dsName))
			{
				//logger.info("DataSource Found .............................................."+temp_dsName);
				dataSourceFlag = true;
				
				//break;				
			}
			else
			{
				dataSourceFlag = false;
			}
		}
		return dataSourceFlag;
	}
	
	public boolean checkForDsWithCase(String textToFind)// finding dataSource with case
	{
		ArrayList ds_name = new DsReader().getDataSourceNames();
		for(int i=0;i<ds_name.size();i++)
		{
			String temp_dsName = (String)ds_name.get(i);
			if(textToFind.equals(temp_dsName))
			{
				//logger.info("DataSource Found .............................................."+temp_dsName);
				dataSourceFlag = true;
				
				break;				
			}
			else
			{
				dataSourceFlag = false;
			}
		}		
		return dataSourceFlag;
	}
	
	public boolean checkForDsInAnyWay(String textToFind)// for searching dataSource using wild cards
	{
		if(textToFind.contains("*"))
		{
			textToFind = textToFind.substring(0,textToFind.length()-1);
		}
		else
		{
			// do nothing
		}
		
		ArrayList ds_name = new DsReader().getDataSourceNames();
		for(int i=0;i<ds_name.size();i++)
		{
			String temp_dsName = (String)ds_name.get(i);			
			if(temp_dsName.startsWith(textToFind.toLowerCase()) || temp_dsName.startsWith(textToFind.toUpperCase()))
			{
				//logger.info("DataSource Found .............................................."+temp_dsName);
				foundDataSourceNames.add(temp_dsName);
			}
			
		}	
		
		if(foundDataSourceNames.size() == 0)
		{
			dataSourceFlag = false;
		}
		else
		{
			dataSourceFlag = true;
		}		
		return dataSourceFlag;
	}
	
	public boolean checkForTableWithoutCase(String textToFind)// Finding table name with case
	{		
		ArrayList dataSourceNames = dataInfoReader.getDataSourceNames();
		for(int i=0;i<dataSourceNames.size();i++)
		{
			ArrayList dataSourceTableNames = dataInfoReader.getTotalTableNamesOfOneDS((String)dataSourceNames.get(i));
			testFindPath = (String)dataSourceNames.get(i);
			for(int j=0;j<dataSourceTableNames.size();j++)
			{
				Object tabTypeObject = (Object)dataSourceTableNames.get(j);
				DsTableInfo tabInfo = (DsTableInfo) tabTypeObject;
				//logger.info("Table name ::  "+tabInfo.getDsTableName());
				
				if(((String)tabInfo.getDsTableName()).equalsIgnoreCase(textToFind))
				{					
					foundTableNames.add(testFindPath);
					//logger.info(" Table Name Found ....>>>>>>>>>>>>>>");
					break;
				}
				else
				{
					//logger.info(" Table Name Not Found ....<<<<<<<<<<<<<<<<<<<<<<<<<<<<");				
				}					
			}
			
			testFindPath = "";
		}//  end of first for loop
		
		if(foundTableNames.size() == 0)
		{
			tableFlag = false;
		}
		else
		{
			tableFlag = true;
		}
		
		return tableFlag;
		
	}
	
	public boolean checkForTableWithCase(String textToFind)// case sensitive searching for table using 
	{
		ArrayList dataSourceNames = dataInfoReader.getDataSourceNames();
		for(int i=0;i<dataSourceNames.size();i++)
		{
			ArrayList dataSourceTableNames = dataInfoReader.getTotalTableNamesOfOneDS((String)dataSourceNames.get(i));
			testFindPath = (String)dataSourceNames.get(i);
			for(int j=0;j<dataSourceTableNames.size();j++)
			{
				Object tabTypeObject = (Object)dataSourceTableNames.get(j);
				DsTableInfo tabInfo = (DsTableInfo) tabTypeObject;
				//logger.info("Table name ::  "+tabInfo.getDsTableName());
				
				if(((String)tabInfo.getDsTableName()).equals(textToFind))
				{					
					foundTableNames.add(testFindPath);
					break;
				}
				else
				{
					//logger.info(" Table Name Not Found ....<<<<<<<<<<<<<<<<<<<<<<<<<<<<");				
				}					
			}
			testFindPath = "";
		}// end of first for loop
		
		if(foundTableNames.size() == 0)
		{
			tableFlag = false;
		}
		else
		{
			tableFlag = true;
		}		
		return tableFlag;
	}
	
	public boolean checkForTableInAnyCase(String textToFind)// search for table using wild card
	{
		// logic for searching table with wild cards		
		//foundTableNames = new ArrayList();
		if(textToFind.contains("*"))
		{
			textToFind = textToFind.substring(0,textToFind.length()-1);
		}
		else
		{
			// do nothing
		}
		ArrayList dataSourceNames = dataInfoReader.getDataSourceNames();
		for(int i=0;i<dataSourceNames.size();i++)
		{
			ArrayList dataSourceTableNames = dataInfoReader.getTotalTableNamesOfOneDS((String)dataSourceNames.get(i));
			testFindPath = (String)dataSourceNames.get(i);
			for(int j=0;j<dataSourceTableNames.size();j++)
			{
				Object tabTypeObject = (Object)dataSourceTableNames.get(j);
				DsTableInfo tabInfo = (DsTableInfo) tabTypeObject;
				//logger.info("Table name ::  "+tabInfo.getDsTableName());
				String temp_DsTabName = tabInfo.getDsTableName();
				if(temp_DsTabName.startsWith(textToFind.toLowerCase()) || temp_DsTabName.startsWith(textToFind.toUpperCase()) )
				{
					foundTableNames.add(testFindPath);
					break;
				}
				else
				{
					//logger.info(" Table Name Not Found ....<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				}					
			}
			testFindPath = "";
		}// end of first for loop
		
		if(foundTableNames.size() == 0)
		{
			tableFlag = false;
		}
		else
		{
			tableFlag = true;
		}
		
		return tableFlag;
	}
	
	public boolean checkForFieldWithCase(String textToFind)// finding field with match case
	{
		ArrayList dataSourceNames = dataInfoReader.getDataSourceNames();
		StringBuilder sBuilder = new StringBuilder();
		DsFieldInfo dsfieldInfo =null;
		String fieldNameCheck;
		int level = 1;// for progress bar
		Shell shell = new Shell(new Shell().getDisplay(),SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL); // for progress bar
		ProgressBar pb = createProgBar(shell);// for progress bar
		Label progBtn = new Label(shell,SWT.NONE | SWT.CENTER); // for progress bar
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);// for progress bar
		gd.verticalSpan = 4;// for progress bar
		progBtn.setLayoutData(gd);// for progress bar
		shell.open();// for progress bar
		
		for(int i=0;i<dataSourceNames.size();i++)
		{
			level = 1;
			ArrayList dataSourceTableNames = dataInfoReader.getTotalTableNamesOfOneDS((String)dataSourceNames.get(i));
			testFindPath = (String)dataSourceNames.get(i);
			pb.setMaximum(dataSourceTableNames.size()); // for progress bar
			shell.setText("Please wait a while, finding the data.... ");// for progress bar
			
			for(int j=0;j<dataSourceTableNames.size();j++)
			{
				DsTableInfo tabInfo = (DsTableInfo) dataSourceTableNames.get(j);
				ArrayList<DsFieldInfo> totalFieldNames_OneTab = dataInfoReader.getTotalFieldNamesFromOneTab(dataSourceNames.get(i).toString(),tabInfo.getDsTableName());
				progBtn.setAlignment(SWT.LEFT);// for progress bar
				progBtn.setText("Finding ...... " );// for progress bar
				pb.setSelection(level);// for progress bar
				level = level+1;// for progress bar
				for(Object fieldObj : totalFieldNames_OneTab)
				{
					dsfieldInfo = (DsFieldInfo) fieldObj;
					fieldNameCheck = dsfieldInfo.getDsFieldName();
					
					if(fieldNameCheck.equals(textToFind))
					{
						sBuilder.append(testFindPath);
						sBuilder.append("/");
						sBuilder.append(tabInfo.getDsTableName());		
						testFindPath = testFindPath+"/"+tabInfo.getDsTableName();
						foundFieldNames.add(testFindPath);
						sBuilder.delete(0,sBuilder.length());						
					}					
				}// end of third inner loop
				testFindPath = (String)dataSourceNames.get(i);
			}// end of second inner loop
			
			testFindPath = "";
		}// end of first loop
		shell.close();//for progress bar
		
		if(foundFieldNames.size() == 0)
		{
			fieldFlag = false;
		}
		else
		{
			fieldFlag = true;
		}
		
		return fieldFlag;		
	}
	
	
	public boolean checkForFieldWithoutCase(String textToFind) // Finding field without case
	{
		ArrayList dataSourceNames = dataInfoReader.getDataSourceNames();
		StringBuilder sBuilder = new StringBuilder();
		DsFieldInfo dsfieldInfo =null;
		String fieldNameCheck;
		int level = 1;// for progress bar
		Shell shell = new Shell(new Shell().getDisplay(),SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL); // for progress bar
		ProgressBar pb = createProgBar(shell);// for progress bar
		Label progBtn = new Label(shell,SWT.NONE | SWT.CENTER); // for progress bar
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);// for progress bar
		gd.verticalSpan = 4;// for progress bar
		progBtn.setLayoutData(gd);// for progress bar
		shell.open();// for progress bar
		
		for(int i=0;i<dataSourceNames.size();i++)
		{
			level = 1;
			ArrayList dataSourceTableNames = dataInfoReader.getTotalTableNamesOfOneDS((String)dataSourceNames.get(i));
			testFindPath = (String)dataSourceNames.get(i);
			pb.setMaximum(dataSourceTableNames.size()); // for progress bar
			shell.setText("Please wait a while, finding the data.... ");// for progress bar
			
			for(int j=0;j<dataSourceTableNames.size();j++)
			{
				DsTableInfo tabInfo = (DsTableInfo) dataSourceTableNames.get(j);
				ArrayList<DsFieldInfo> totalFieldNames_OneTab = dataInfoReader.getTotalFieldNamesFromOneTab(dataSourceNames.get(i).toString(),tabInfo.getDsTableName());
				progBtn.setAlignment(SWT.LEFT);// for progress bar
				progBtn.setText("Finding ...... " );// for progress bar
				pb.setSelection(level);// for progress bar
				level = level+1;// for progress bar
				
				for(Object fieldObj : totalFieldNames_OneTab)
				{
					dsfieldInfo = (DsFieldInfo) fieldObj;
					fieldNameCheck = dsfieldInfo.getDsFieldName();
					
					if(fieldNameCheck.equalsIgnoreCase(textToFind))
					{						
						sBuilder.append(testFindPath);
						sBuilder.append("/");
						sBuilder.append(tabInfo.getDsTableName());		
						testFindPath = testFindPath+"/"+tabInfo.getDsTableName();
						foundFieldNames.add(testFindPath);				
						sBuilder.delete(0,sBuilder.length());
						break;
					}	
				}
				testFindPath = (String)dataSourceNames.get(i);
			}
			
			testFindPath = "";
		}
		shell.close();//for progress bar
		
		if(foundFieldNames.size() == 0)
		{
			fieldFlag = false;
		}
		else
		{
			fieldFlag = true;
		}		
		return fieldFlag;
		
	}
	
	public boolean checkForFieldInAnyWay(String textToFind,final Composite parent) //searching field name using wild cards
	{
		// logic for searching field name using wild card
		
		if(textToFind.contains("*"))
		{
			textToFind = textToFind.substring(0,textToFind.length()-1);
		}
		else
		{
			// do nothing
		}
		
		ArrayList dataSourceNames = dataInfoReader.getDataSourceNames();
		StringBuilder sBuilder = new StringBuilder();
		DsFieldInfo dsfieldInfo =null;
		String fieldNameCheck;
		int level = 1;// for progress bar
		Shell shell = new Shell(new Shell().getDisplay(),SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL); // for progress bar
		ProgressBar pb = createProgBar(shell);// for progress bar
		Label progBtn = new Label(shell,SWT.NONE | SWT.CENTER); // for progress bar
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);// for progress bar
		gd.verticalSpan = 4;// for progress bar
		progBtn.setLayoutData(gd);// for progress bar
		shell.open();// for progress bar
		
		for(int i=0;i<dataSourceNames.size();i++)
		{
			level=1; // for progress bar
			ArrayList dataSourceTableNames = dataInfoReader.getTotalTableNamesOfOneDS((String)dataSourceNames.get(i));
			testFindPath = (String)dataSourceNames.get(i);
			pb.setMaximum(dataSourceTableNames.size()); // for progress bar
			shell.setText("Please wait a while, finding the data.... ");// for progress bar
			
			for(int j=0;j<dataSourceTableNames.size();j++)
			{
				DsTableInfo tabInfo = (DsTableInfo) dataSourceTableNames.get(j);
				ArrayList<DsFieldInfo> totalFieldNames_OneTab = dataInfoReader.getTotalFieldNamesFromOneTab(dataSourceNames.get(i).toString(),tabInfo.getDsTableName());
				progBtn.setAlignment(SWT.LEFT);// for progress bar
				progBtn.setText("Finding ...... " );// for progress bar
				pb.setSelection(level);// for progress bar
				level = level+1;// for progress bar
				
				for(Object fieldObj : totalFieldNames_OneTab)
				{
					dsfieldInfo = (DsFieldInfo) fieldObj;
					fieldNameCheck = dsfieldInfo.getDsFieldName();
					if(fieldNameCheck.startsWith(textToFind.toLowerCase()) || fieldNameCheck.startsWith(textToFind.toUpperCase()) )
					{						
						sBuilder.append(testFindPath);
						sBuilder.append("/");
						sBuilder.append(tabInfo.getDsTableName());		
						testFindPath = testFindPath+"/"+tabInfo.getDsTableName();
						foundFieldNames.add(testFindPath);				
						sBuilder.delete(0,sBuilder.length());
						break;
					}	
				}
				testFindPath = (String)dataSourceNames.get(i);
			}
			testFindPath = "";
		}
		
		shell.close();//for progress bar
		
		if(foundFieldNames.size() == 0)
		{
			fieldFlag = false;
		}
		else
		{
			fieldFlag = true;
		}		
		return fieldFlag;
		
	}
	
	// check for all cases in finding data
	public void checkForAllCasesInFind(final Composite parent)
	{
		//parent.getShell().close();
		okButton.setEnabled(false);
		cancelButton.setEnabled(false);
		parent.setEnabled(false);		
		String textToFind = findText.getText();
		
		if(tableButton.getSelection())// when table button is selected
		{
			if( matchButton.getSelection())
			{
				boolean checkTabFlagMatchCase = checkForTableWithCase(textToFind);
				if(checkTabFlagMatchCase)
				{
					//logger.info("Match Button has been selected ...");
					ShowDataDialog showDialog = new ShowDataDialog(parent.getShell(),foundTableNames,"Displays the list of dataSources containing tables");
					showDialog.open();
				}
				else
				{
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" not found");
				}
			}
			
			else if(matchWholewordButton.getSelection())
			{
				// action for selection of matchWholewordButton				
				boolean checkTabFlagMatchCase = checkForTableInAnyCase(textToFind);
				if(checkTabFlagMatchCase)
				{
					//logger.info("Match Button has been selected ...");
					ShowDataDialog showDialog = new ShowDataDialog(parent.getShell(),foundTableNames,"Displays the list of dataSources containing tables");
					showDialog.open();
				}
				else
				{
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" not found");
				}				
			}
			else
			{
				boolean checkTableFlag = checkForTableWithoutCase(textToFind);
				//logger.info("Table Button has been selected ...");
				if(checkTableFlag)
				{
					//logger.info("Match Button has been selected ...");
					ShowDataDialog showDialog = new ShowDataDialog(parent.getShell(),foundTableNames,"Displays the list of dataSources containing tables");
					showDialog.open();
				}
				else
				{
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" not found");
				}
			}
		}// end of if(tableButton.getSelection), table button functionality ends here
		
		else if(dsButton.getSelection())// when data source button is selected
		{
			if(matchButton.getSelection())
			{
				boolean flagCheckDs = checkForDsWithCase(textToFind);
				if(flagCheckDs)
				{
					//logger.info("DataSource Button has been selected ...");
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" found");
				}
				else
				{
					//logger.info("DataSource Button has been selected ...");
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" not found");
				}						
			}
			
			else if(matchWholewordButton.getSelection())// when match whole word check box is selected
			{
				// searching for dataSource name in any way using *
				boolean flagCheckDs = checkForDsInAnyWay(textToFind);
				if(flagCheckDs)
				{
					//logger.info("DataSource Button has been selected ...");
					//MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" found");
					
					ShowDataDialog showDialog = new ShowDataDialog(parent.getShell(),foundDataSourceNames,"List of dataSources ");
					showDialog.open();
				}
				//else if(matchWholewordButton.getSelection() && matchButton.getSelection())
				else
				{
					//logger.info("DataSource Button has been selected ...");
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" not found");
				}										
			}
			
			else
			{
				boolean flagCheckDs = checkForDsWithoutCase(textToFind);
				if(flagCheckDs)
				{
					//logger.info("DataSource Button has been selected ...");
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" found");
				}
				else
				{
					//logger.info("DataSource Button has been selected ...");
					MessageDialog.openInformation(parent.getShell(),"Message",textToFind+" not found");
				}	
			}
		}// end of DataSource button, dataSource button functionality ends here
		
		else if(fieldButton.getSelection())// When field button is selected
		{
			if(matchButton.getSelection())
			{
				
				//logger.info("match button for field radio button is selected .........................");
				boolean flagCheckFields = checkForFieldWithCase(textToFind);
				if(flagCheckFields)
				{
					//logger.info("Field Button has been selected ...");
					ShowDataDialog showDialog = new ShowDataDialog(parent.getShell(),foundFieldNames,"List of dataSources and tables containing fields");
					showDialog.open();
				}
				else 
				{
					MessageDialog.openInformation(parent.getShell(),"Message","Field name "+textToFind+" not found ");
				}
				
			}// end of if
			
			else if(matchWholewordButton.getSelection())
			{
				// action for selecting matchWholewordButton
				boolean flagCheckFields = checkForFieldInAnyWay(textToFind,parent);
				
				if(flagCheckFields)
				{
					//logger.info("Field Button has been selected ...");
					ShowDataDialog showDialog = new ShowDataDialog(parent.getShell(),foundFieldNames,"List of dataSources and tables containing fields");
					showDialog.open();
				}
				else 
				{
					MessageDialog.openInformation(parent.getShell(),"Message","Field name "+textToFind+" not found ");
				}
			}
			
			else
			{
				boolean flagCheckFields = checkForFieldWithoutCase(textToFind);
				if(flagCheckFields)
				{
					//logger.info("Field Button has been selected ...");
					ShowDataDialog showDilog = new ShowDataDialog(parent.getShell(),foundFieldNames,"List of dataSources and tables containing fields");
					showDilog.open();
				}
				else 
				{
					MessageDialog.openInformation(parent.getShell(),"Message","Field name "+textToFind+" not found ");
				}
			}// end of else
		}// end of else if (fieldButton.getSelection())
	}
	
	public void showProgressBar(final Composite parent)
	{
		
		ProgressBar progressBar = new ProgressBar(new Shell(parent.getShell()),SWT.SMOOTH);
		progressBar.setMinimum(0);
		progressBar.setMaximum(10);
		
	}
	private ProgressBar createProgBar(Shell shell)//,int maxLimit)
	{
		
		ProgressBar pb = new ProgressBar(shell, SWT.CENTER);
		try
		{
			shell.setLayout(new GridLayout(1, false));
			pb.setMinimum(0);
			GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
			gd1.verticalSpan = 12;
			pb.setLayoutData(gd1);
			shell.setSize(650,150);
		}
		catch(Exception ex)
		{
		}
		return pb;
	}
	
	
}
