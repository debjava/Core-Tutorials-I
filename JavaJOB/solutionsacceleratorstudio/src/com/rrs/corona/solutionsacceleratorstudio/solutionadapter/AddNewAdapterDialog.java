/******************************************************************************
 * @rrs_start_copyright
 *
 * Copyright 2005 (C) Red Rabbit Software Inc. All rights reserved.
 * This software is the confidential and proprietary information of Red Rabbit
 * Software, Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms of
 * the license agreement you entered into with Red Rabbit Software.
 © 2004-2005, Red Rabbit Software Inc. Confidential Information. All rights reserved.
 Red Rabbit Software - Development Program 5 of 15
 *$Id: AddNewAdapterDialog.java,v 1.2 2006/07/28 13:26:16 redrabbit Exp $
 *$Source: /home/redrabbit/cvs_july_2006/corona/sources/main/solutionsacceleratorstudio/src/com/rrs/corona/solutionsacceleratorstudio/solutionadapter/AddNewAdapterDialog.java,v $
 * @rrs_end_copyright
 ******************************************************************************/
/******************************************************************************
 * @rrs_start_disclaimer
 *
 * The contents of this file are subject to the Red Rabbit Software Inc. Corona License
 * ("License"); You may not use this file except in compliance with the License.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE RED RABBIT SOFTWARE INC. OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * @rrs_end_disclaimer
 ******************************************************************************/
package com.rrs.corona.solutionsacceleratorstudio.solutionadapter;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

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

import com.rrs.corona.solutionsacceleratorstudio.plugin.DsReader;
import com.rrs.corona.solutionsacceleratorstudio.plugin.SolutionsacceleratorstudioPlugin;

public class AddNewAdapterDialog extends TitleAreaDialog {

	/**
	 * Push button for ok button
	 */
	transient private Button okButton = null;// ok button

	/**
	 * push button for cancel button
	 */
	transient private Button cancelButton = null;// for cancel button

	/**
	 * text field for adapter name
	 */
	transient private Text adapterName = null; // name of the CMS Server text
												// field

	/**
	 * User Interface combo box which will contain server name
	 */
	transient private Combo serverName = null;// name of the IP address of the
												// CMS Server

	/**
	 * User Interface combo box which will contain data source name
	 */
	transient public Combo dataSource = null;// name of the datasources

	/**
	 * User Interface combo box which will contain data source name
	 */
	transient public Label errorLabel = null;// name of the port

	/**
	 * Constructor for AddCMSServerDialog
	 * 
	 * @param parentShell
	 */
	public AddNewAdapterDialog(Shell parentShell) {
		super(parentShell);
		SolutionAdapterView.serverName_s = null;
		SolutionAdapterView.dataSourceName_s = null;
		SolutionAdapterView.adapterName_s = null;
	}

	/**
	 * Method to create window widget
	 */
	public void create() {
		super.create();
		setTitle("Solution Accelerator Studio");
		setMessage("Create New Solutions Adapter");
	}

	/**
	 * Creates and returns the upper part of the dialog
	 * 
	 * @return parent of type Composite
	 */
	public Control createDialogArea(Composite parent) {
		try {
			parent.getShell().setText("Add New Adapter");// Shell message
			// Method to create the dialog box and its associated controls in
			// the container
			createWorkArea(parent);
			return parent;
		} catch (Exception ex) {
			final String errMsg = "Exception thrown in Method "
					+ "**createDialogArea()** in class [ AddNewAdapteDialog ]";
			SolutionsacceleratorstudioPlugin.getDefault().logError(errMsg, ex);
			ex.printStackTrace();
		}
		return parent;
	}

	/**
	 * Adds button to the button bar of the dialog box
	 */
	public void createButtonsForButtonBar(final Composite parent) {
		try {
			okButton = createButton(parent, 999, "OK", true);// for ok button
			okButton.setEnabled(false);
			cancelButton = createButton(parent, 999, "Cancel", true);
			okButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					try {
						SolutionAdapterView.adapterName_s = adapterName
								.getText();
						SolutionAdapterView.serverName_s = serverName.getText();
						SolutionAdapterView.dataSourceName_s = dataSource
								.getText();
						parent.getShell().close();
					} catch (Exception exc) {
						parent.getShell().close();
					}
				}
			});
			cancelButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					parent.getShell().close();
				}
			});
		} catch (Exception e) {
			final String errMsg = "Exception thrown in Method "
					+ "**createButtonsForButtonBar()** in class [ AddNewAdapteDialog ]";
			SolutionsacceleratorstudioPlugin.getDefault().logError(errMsg, e);
			e.printStackTrace();
		}

	}

	/**
	 * Working area and logic for UserInterface design and business logic
	 * 
	 * @param parent
	 */
	private void createWorkArea(Composite parent) {
		Composite area = new Composite(parent, SWT.NULL);
		Group firstGroup = new Group(area, SWT.NONE);
		GridData gdData1 = new GridData(GridData.FILL_HORIZONTAL);
		firstGroup.setLayout(new GridLayout(3, true));
		GridData gridData = new GridData();
		createLabel(firstGroup, "Adapter Name", gridData);
		createAdapterNameText(firstGroup, gdData1);
		createLabel(firstGroup, "Server Name", gridData);
		createServerName(firstGroup, gdData1);
		createLabel(firstGroup, "Data Source", gridData);
		createDataSource(firstGroup, gdData1);
		firstGroup.setBounds(25, 25, 380, 120);
	}

	/**
	 * Method to create a label
	 * 
	 * @param firstGroup
	 *            of type Composite
	 * @param text
	 *            of type String
	 * @param gridData
	 *            of type GridData
	 */
	private void createLabel(final Composite firstGroup, final String text,
			GridData gridData) {// This method is used to create a label
		Label labelName = new Label(firstGroup, SWT.LEFT);
		labelName.setText(text);
		labelName.setLayoutData(gridData);
	}

	/**
	 * Creates a text field for adapter name
	 * 
	 * @param firstGroup
	 * @param gdData
	 */
	private void createAdapterNameText(final Composite firstGroup,
			GridData gdData) {
		adapterName = new Text(firstGroup, SWT.BORDER); // Creates a text box
		gdData = new GridData(GridData.FILL_HORIZONTAL);
		gdData.horizontalSpan = 2;
		adapterName.setLayoutData(gdData);
	}

	/**
	 * Method to create a combo box for server names
	 * 
	 * @param firstGroup
	 *            of type Composite
	 * @param gdData
	 *            of type GridData
	 */
	public void createServerName(Composite firstGroup, GridData gdData) {
		ReadAndWriteXML readObj = new ReadAndWriteXML();

		String servers[];
		try {
			servers = readObj.getCmsServer();
			if (null != servers) {
				serverName = new Combo(firstGroup, SWT.BORDER);
				gdData = new GridData(GridData.FILL_HORIZONTAL);
				gdData.horizontalSpan = 2;
				serverName.setLayoutData(gdData);
				serverName.setItems(servers);
				serverName.setText(serverName.getItem(0));
			} else {
				createErrorLable("Please Add Server Information", firstGroup,
						gdData);
			}
		} catch (JAXBException e) {
			final String errMsg = "Exception thrown in Method "
					+ "**createServerName()** in class [ AddNewAdapteDialog ]";
			SolutionsacceleratorstudioPlugin.getDefault().logError(errMsg, e);
			createErrorLable("Incorrect XML file", firstGroup, gdData);
		}
	}

	/**
	 * This method is used to create the datasource combo box which will contain
	 * the available data source name in the xml file
	 * 
	 * @param firstGroup
	 *            of type Composite
	 * @param gdData
	 *            of type GridData
	 */

	public void createDataSource(Composite firstGroup, GridData gdData) {
		DsReader dsObj = new DsReader();
		ArrayList listOfDs = dsObj.getDataSourceNames();
		if (null != listOfDs) {
			String[] dsNames = new String[listOfDs.size()];
			for (int i = 0; i < listOfDs.size(); i++) {
				dsNames[i] = (String) listOfDs.get(i);
			}
			if (dsNames.length >= 1) {
				dataSource = new Combo(firstGroup, SWT.BORDER);
				gdData = new GridData(GridData.FILL_HORIZONTAL);
				gdData.horizontalSpan = 2;
				dataSource.setLayoutData(gdData);
				dataSource.setItems(dsNames);
				dataSource.setText(dataSource.getItem(0));
			} else {
				createErrorLable("Please Add DataSource Information",
						firstGroup, gdData);
			}
		}
		setListeners();
	}

	private void createErrorLable(String message, Composite firstGroup,
			GridData gdData) {
		gdData = new GridData(GridData.FILL_HORIZONTAL);
		gdData.horizontalSpan = 2;
		errorLabel = new Label(firstGroup, SWT.NULL);
		errorLabel.setText(message);
		errorLabel.setLayoutData(gdData);
	}

	private void setListeners() {
		adapterName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (checkForLength()) {
					if (checkForSpace()) {
						okButton.setEnabled(true);
					} else {
						okButton.setEnabled(false);
					}
				} else {
					okButton.setEnabled(false);
				}
			}

		});
	}

	private boolean checkForSpace() {
		boolean flag = true;
		if (adapterName.getText().charAt(0) == ' ') {
			flag = false;
		}
		return flag;
	}

	private boolean checkForLength() {
		boolean flag = true;
		if (adapterName.getText().length() == 0) {
			flag = false;
		}
		return flag;
	}

}
