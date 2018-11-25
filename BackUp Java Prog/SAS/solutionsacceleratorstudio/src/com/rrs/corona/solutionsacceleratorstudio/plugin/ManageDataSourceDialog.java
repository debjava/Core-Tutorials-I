
package com.rrs.corona.solutionsacceleratorstudio.plugin;
/**
 * @author Debadatta Mishra
 */
import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.rrs.corona.Sas.DataSourceList;
import com.rrs.corona.Sas.Sas;
public class ManageDataSourceDialog extends TitleAreaDialog
{
	transient private Button okButton = null;
	transient private Button cancelButton =  null;
	Text commentText;
	boolean testFlag = false;
	Button addBtn ;
	Text dsFilterText;
	List totalDsList ; // for Data Source List box
	List selectedDsList ; // for selected Data Source List box
	Button rightArrowButton; // for right arrow butto
	Button leftArrowButton; // for left arrow Button 
	String selectedDsnameList[] ;
	ArrayList selectedDsItemList1 = new ArrayList();
	static ArrayList totalDsitemList = new ArrayList();
	boolean checkDuplicate = false;
	
	public ManageDataSourceDialog(Shell parentShell) 
	{
		super(parentShell);	
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage("Select Data Source from list");
	}
	
	public Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("Manage Data Source");
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
					showAllDsInformationInTree(parent);// It will show all the datasources , tables and fields
					
					for(int val=0;val<selectedDsItemList1.size();val++)
					{
						totalDsitemList.add(selectedDsItemList1.get(val));
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
	
	private void createWorkArea(Composite parent)
	{
		Composite area = new Composite(parent, SWT.NULL);				
		Composite firstGroup = new Composite(area, SWT.NONE); // 1st group
		GridLayout newGrid = new GridLayout(3,true);		
		firstGroup.setLayout(newGrid); // lay out
		GridData gridData = new GridData(); // to show in a grid
		createLabel(firstGroup,"Data Source list\t             ",gridData);
		createLabel(firstGroup," ",gridData);
		createLabel(firstGroup,"Selected Data Source list",gridData);
		createTotalDsList(firstGroup,gridData);
		GridData butonGrid = new GridData(GridData.HORIZONTAL_ALIGN_CENTER |GridData.VERTICAL_ALIGN_CENTER);
		createFirstButton(firstGroup,butonGrid);
		createSelectedDsList(firstGroup,gridData);	
		createSecondButton(firstGroup,butonGrid);
		createLabel(firstGroup,"Data Source filter",gridData);
		createLabel(firstGroup,"",gridData);
		createLabel(firstGroup,"Selected Data Source filter",gridData);
		createDsFilterText(firstGroup,gridData);
		createLabel(firstGroup,"",gridData);
		createSelectedDsFilterText(firstGroup,gridData);
		//firstGroup.setBounds(25, 25, 380, 130);
		firstGroup.setBounds(40, 60, 600, 230);
	}
	
	public void createLabel(Composite firstGroup,String text,GridData gridData)
	{
		Label firstLabel = new Label(firstGroup, SWT.LEFT);	// It should be initialized first, First Label	
		firstLabel.setText(text); // Label Name of the test field to be displayed		
		firstLabel.setLayoutData(gridData); 
		//checkforText();
	}
	
	public void createTotalDsList(Composite firstGroup,GridData gridData)
	{
		totalDsList = new List(firstGroup,SWT.BORDER|SWT.V_SCROLL|SWT.WRAP); // for total no of datasource list
		//gridData = new GridData(GridData.FILL_BOTH);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.verticalSpan = 2;
		//gridData.horizontalSpan = 2;
		totalDsList.setLayoutData(gridData);
		populateDsList();
	}
	
	public void createSelectedDsList(Composite firstGroup,GridData gridData)
	{
		selectedDsList = new List(firstGroup,SWT.BORDER|SWT.V_SCROLL|SWT.WRAP); // for selected Datasource List
		//checkforText();
		//gridData = new GridData(GridData.FILL_BOTH);
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.verticalSpan = 2;
		//gridData.horizontalSpan = 2;
		selectedDsList.setLayoutData(gridData);
	}
	
	public void createFirstButton(final Composite firstGroup,GridData butonGrid)
	{
		rightArrowButton = new Button(firstGroup,SWT.PUSH);
		rightArrowButton.setText(">>");
		rightArrowButton.setLayoutData(butonGrid);
		
		rightArrowButton.addSelectionListener(new SelectionAdapter()
				{
			public void widgetSelected(SelectionEvent e) 
			{
				// action logic for button
				String selectedDsnameList[] = totalDsList.getSelection();
				for(int i=0;i<selectedDsnameList.length;i++)
				{
					String selectedItem = selectedDsnameList[i];
					//selectedDsList.add(selectedItem);
					selectedDsItemList1.add(selectedItem);
					//totalDsitemList.add(selectedItem);// new 
					checkforText();
					
					if(totalDsitemList.contains(selectedItem))
					{
						MessageDialog.openWarning(firstGroup.getShell(),"Warning","The tree already contains this dataSource, please select a different data source name");
						selectedDsItemList1.remove(selectedItem);
						selectedDsList.remove(selectedItem);
						totalDsitemList.remove(selectedItem);// new 
					}
					
					checkDuplicate = checkForDuplicates(selectedDsItemList1,selectedItem);
					if(checkDuplicate == false)
					{
						MessageDialog.openWarning(firstGroup.getShell(),"Warning","Selected list already contains this data source, please select a different data source name");
						selectedDsItemList1.remove(selectedItem);
					}					
					else
					{
						selectedDsList.add(selectedItem);
						okButton.setEnabled(true);
					}
					
					checkforText();
				}
				
			}
				});
	}
	
	public void createSecondButton(Composite firstGroup,GridData butonGrid)
	{
		leftArrowButton = new Button(firstGroup,SWT.PUSH);
		leftArrowButton.setText("<<");
		leftArrowButton.setLayoutData(butonGrid);
		
		leftArrowButton.addSelectionListener(new SelectionAdapter()
				{
			public void widgetSelected(SelectionEvent e) 
			{
				// action logic for button
				selectedDsnameList = selectedDsList.getSelection();
				for(int i=0;i<selectedDsnameList.length;i++)
				{
					String selectedItem = selectedDsnameList[i];
					selectedDsList.remove(selectedItem);
					selectedDsItemList1.remove(selectedItem); ///
					checkforText(); // to enable or disable the okButton
				}
			}
				});
	}
	
	public void createDsFilterText(Composite firstGroup,GridData gridData)
	{
		dsFilterText = new Text(firstGroup, SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		//gridData.horizontalSpan = 2;		
		dsFilterText.setLayoutData(gridData);
	}
	
	public void createSelectedDsFilterText(Composite firstGroup,GridData gridData)
	{
		dsFilterText = new Text(firstGroup, SWT.BORDER);
		gridData = new GridData(GridData.FILL_HORIZONTAL);		
		//gridData.horizontalSpan = 2;		
		dsFilterText.setLayoutData(gridData);
	}
	
	public void populateDsList()
	{
		DsReader dsreader = new DsReader();
		ArrayList dataSourcenamesList =  dsreader.getDataSourceNames();
		for(int i=0;i<dataSourcenamesList.size();i++)
		{
			String dsname = (String)dataSourcenamesList.get(i);
			totalDsList.add((String)dsname);
		}	
	}
	public void checkforText()
	{
		if(selectedDsList.getItemCount()>0)
		{
			okButton.setEnabled(true);
		}
		else
		{
			okButton.setEnabled(false);
		}
	}
	
	public boolean checkForDuplicates(ArrayList selectedDsnameList,String item)
	{
		boolean returnFlag = false;
		HashSet newHashSet = new HashSet();
		for(int i=0;i<selectedDsnameList.size();i++)
		{
			newHashSet.add(selectedDsnameList.get(i));
		}
		
		if(newHashSet.size()< selectedDsnameList.size() )
		{
			returnFlag = false;			
		}
		else if(newHashSet.size()== selectedDsnameList.size())
		{
			returnFlag = true;
			okButton.setEnabled(true);
		}
		else
		{
			returnFlag = true;
			okButton.setEnabled(true);
		}
		
		return returnFlag;
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
	
	public void showAllDsInformationInTree(final Composite parent)
	{
		int level = 1;
		parent.getShell().close();
		Shell shell = new Shell(new Shell().getDisplay(),SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		ProgressBar pb = createProgBar(shell);
		Label progBtn = new Label(shell,SWT.NONE | SWT.CENTER); 
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.verticalSpan = 4;
		progBtn.setLayoutData(gd);
		shell.open();
		
		for(int i=0;i<selectedDsItemList1.size();i++)
		{
			level=1;
			String showDsname = (String)selectedDsItemList1.get(i);
			TreeParent treeObject = new TreeParent(showDsname);
			treeObject.setType("group");
			IStructuredSelection iStructuredSelection = (IStructuredSelection) DatabaseViewer.viewer.getSelection();
			TreeParent treeParent1 = (TreeParent) iStructuredSelection.getFirstElement();
			treeParent1.addChild(treeObject);
			ArrayList totalTableNames = new DsReader().getTotalTableNamesOfOneDS(showDsname);
			pb.setMaximum(totalTableNames.size());
			shell.setText("Loading "+showDsname);
			
			for(int j=0;j<totalTableNames.size();j++)
			{
				Object object1 = (Object)totalTableNames.get(j);
				DsTableInfo tabInfo = (DsTableInfo)object1;																		
				String tab_Name = tabInfo.getDsTableName();
				TreeParent treeParent2 = new TreeParent(tab_Name);
				treeObject.addChild(treeParent2);
				treeParent2.setType("table");
				ArrayList totalFieldNames_OneTab = new DsReader().getTotalFieldNamesFromOneTab(showDsname,tab_Name);
				progBtn.setAlignment(SWT.LEFT);
				progBtn.setText("Loading tables " + tab_Name);
				pb.setSelection(level);
				level = level+1;
				
				//showProgressBar(parent);
				for(int k=0;k<totalFieldNames_OneTab.size();k++)
				{
					Object fieldObject = (Object)totalFieldNames_OneTab.get(k);
					DsFieldInfo dsfieldInfo =(DsFieldInfo) fieldObject ;
					String showFieldNType = dsfieldInfo.getDsFieldName()+"   ::   "+"< "+dsfieldInfo.getDsFieldType()+" >";
					//TreeParent treeParent3 = new TreeParent(showFieldNType);
					TreeObject fieldObject11 = new TreeObject(showFieldNType);
					fieldObject11.setDataType(dsfieldInfo.getDsFieldType());
					//treeParent2.addChild(treeParent3);
					treeParent2.addChild(fieldObject11);
					fieldObject11.setType("field");
				}
			}
			
			//shell.close();
			DatabaseViewer.viewer.refresh(treeParent1,false);
		}
		
		shell.close();
	}
}
