
package com.rrs.corona.solutionsacceleratorstudio.plugin;

import java.util.ArrayList;
//import java.util.logging.Logger;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
/**
 * 
 * @author Debadatta Mishra
 *
 */
public class ShowDataDialog extends TitleAreaDialog 
{
	public ArrayList dataList = new ArrayList();
	public String labelName = null;
	//Logger logger = Logger.getLogger("ShowDataDialog.class");
	
	public ShowDataDialog(Shell parentShell,ArrayList displayList,String dataName) 
	{
		super(parentShell);
		dataList = displayList;
		labelName = dataName;
	}
	
	public void create()
	{
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage(labelName);
	}
	
	public Control createDialogArea(Composite parent)
	{
		parent.getShell().setText("Display data ");   
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
	
	public void createWorkArea(Composite parent)
	{
		Composite area = new Composite(parent, SWT.NULL);			
		Composite     firstGroup = new Composite(area, SWT.NONE); // 1st group
		GridData gdData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		firstGroup.setLayout(new GridLayout(3, true)); // lay out
		GridData gridData = new GridData();
		createLabel(firstGroup,"",gdData1);
		createLabel(firstGroup,"",gdData1);// empty label
		createLabel(firstGroup,"",gdData1);// empty label
		createDisplayDataList(firstGroup,gdData1);	
		firstGroup.setBounds(25, 25, 380, 120);
	}
	
	public void createLabel(Composite firstGroup,String text,GridData gridData)
	{
		Label labelName = new Label(firstGroup, SWT.LEFT);	// It should be initialized first	
		labelName.setText(text); // Label Name of the test field to be displayed	
		labelName.setLayoutData(gridData); 
	}
	
	public void createDisplayDataList(Composite firstGroup,GridData gdData1)
	{
		List  listOfData = new List(firstGroup,SWT.BORDER | SWT.V_SCROLL ); // for showing data in a list
		listOfData.setBounds(25, 25, 380, 120);
		gdData1 = new GridData(GridData.FILL_HORIZONTAL);// It should be initialized first
		//gdData1.horizontalSpan = 2;
		gdData1.horizontalSpan = 3;
		
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.verticalSpan = 3;
		
		for(int i=0;i<dataList.size();i++)
		{
			listOfData.add((String)dataList.get(i));
			//logger.info("Data Names =======>>>>>>  "+dataList.get(i));
		}
		//listOfData.setBounds(25, 25, 380, 120);	
		listOfData.setLayoutData(gdData1);		
	}
	
	
}
