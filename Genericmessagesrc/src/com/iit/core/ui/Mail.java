package com.iit.core.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;

import javax.swing.WindowConstants;

public class Mail extends javax.swing.JFrame implements ActionListener {

	private JToolBar jToolBar;

	private JPanel jPanel;

	private JTextField jTextTemplatePath;

	private JLabel jLabelEventCode0;

	private JLabel jLabelFunctionName;

	private JLabel jLabelFileAttach;

	private JButton jButtonDBConfig;

	private JLabel jLabelAttachType;

	private JLabel jLabelTemplatePath;

	private JLabel jLabelFunctionType;

	private JLabel jLabelTemplateName;

	private JLabel jLabelDescription;

	private JLabel jLabelExternalSys;

	private JLabel jLabelEventCode;

	private JButton jButtonClear;

	private JButton jButtonSave;

	private JButton jButtonSMS;

	private JButton jButtonEmail;

	private JTextField jTextAttachPath;

	private JTextField jTextAttachType;

	private JCheckBox jCheckFileAttach;

	private JTextField jTextTemplateName;

	private JTextField jTextFunctionType;

	private JTextField jTextFunctionName;

	private JTextArea jTextAreaDescription;

	private JTextField jTextExtSystem;

	private JTextField jTextEventCode;

	public static ChildEmail ChilEmailInst = null;

	public static ChildSMS ChildSMSInst = null;

	public static ChildDBConfig ChildDBConfigInst = null;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static String emailName;

	public static String emailTo;

	public static String emailFromName;

	public static String emailCC;

	public static String emailBCC;

	public static String emailSubject;

	public static String emailPriority;

	public static String smsToName;

	public static String smsFromName;

	public static String smsCellNo;

	public static String dbDBServerPort;

	public static String dbDBServerIP;

	public static String dbDBName;

	public static String dbDBUserName;

	public static String dbDBUserPWD;

	public static String dbDBSID;

	public static String dbDeliveryFreq;

	public static void main(String[] args) {
		Mail inst = new Mail();
		inst.setVisible(true);
	}

	public Mail() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jToolBar = new JToolBar();
				getContentPane().add(jToolBar, BorderLayout.NORTH);
				jToolBar.setPreferredSize(new java.awt.Dimension(522, 29));
				{
					jButtonSave = new JButton();
					jToolBar.add(jButtonSave);
					// jButtonSave.setText("Save");
					jButtonSave.setToolTipText("Save");
					jButtonSave.setIcon(UIImages.getSaveImage());
					jButtonSave.addActionListener(this);
				}
				{
					jButtonClear = new JButton();
					jToolBar.add(jButtonClear);
					// jButton4.setText("Clear");
					jButtonClear.setToolTipText("Clear");
					jButtonClear.setIcon(UIImages.getClearImage());
					jButtonClear.addActionListener(this);
				}
			}
			{
				jPanel = new JPanel();
				getContentPane().add(jPanel, BorderLayout.CENTER);
				GridBagLayout jPanelLayout = new GridBagLayout();
				jPanelLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
						0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
				jPanelLayout.rowHeights = new int[] { 44, 34, 52, 31, 32, 29,
						31, 31, 105, 4 };
				jPanelLayout.columnWeights = new double[] { 0.0, 0.0, 0.0,
						0.0, 0.0, 0.1 };
				jPanelLayout.columnWidths = new int[] { -1, 29, 113, 158, 105,
						7 };
				FlowLayout jPanel2Layout = new FlowLayout();
				jPanel.setBackground(new java.awt.Color(192, 192, 192));
				jPanel.setLayout(jPanelLayout);
				{
					jTextEventCode = new JTextField();
					jPanel.add(jTextEventCode, new GridBagConstraints(3, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.SOUTHWEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextEventCode
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextExtSystem = new JTextField();
					jPanel.add(jTextExtSystem, new GridBagConstraints(3, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextExtSystem
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextAreaDescription = new JTextArea();
					// jPanel.add(jTextAreaDescription, new GridBagConstraints(3, 2, 1,
					// 1, 0.0, 0.0, GridBagConstraints.WEST,
					// GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
//					jTextAreaDescription
//							.setPreferredSize(new java.awt.Dimension(50, 20));
					JScrollPane areaScrollPane = new JScrollPane(jTextAreaDescription);
					areaScrollPane
							.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
					areaScrollPane.setBorder(BorderFactory.createMatteBorder(1,
							1, 1, 1, new java.awt.Color(0, 0, 0)));
					jPanel.add(areaScrollPane, new GridBagConstraints(3, 2, 1,
							1, 0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.BOTH, new Insets(3, 0, 0, 0), 0,
							0));
				}
				{
					jTextFunctionName = new JTextField();
					jPanel.add(jTextFunctionName, new GridBagConstraints(3, 3, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextFunctionName
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextFunctionType = new JTextField();
					jPanel.add(jTextFunctionType, new GridBagConstraints(5, 3, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextFunctionType
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextTemplateName = new JTextField();
					jPanel.add(jTextTemplateName, new GridBagConstraints(3, 4, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextTemplateName
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextTemplatePath = new JTextField();
					jPanel.add(jTextTemplatePath, new GridBagConstraints(5, 4, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextTemplatePath
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jCheckFileAttach = new JCheckBox();
					jPanel.add(jCheckFileAttach, new GridBagConstraints(3, 5, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
				}
				{
					jTextAttachType = new JTextField();
					jPanel.add(jTextAttachType, new GridBagConstraints(3, 6, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextAttachType
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextAttachPath = new JTextField();
					jPanel.add(jTextAttachPath, new GridBagConstraints(3, 7, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jTextAttachPath
							.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jButtonEmail = new JButton();
					jPanel.add(jButtonEmail, new GridBagConstraints(3, 8, 1,
							1, 0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jButtonEmail.setToolTipText("E-Mail");
					jButtonEmail.setIcon(UIImages.getEmailImage());
					jButtonEmail.addActionListener(this);
				}
				{
					jButtonSMS = new JButton();
					jPanel.add(jButtonSMS, new GridBagConstraints(3, 8, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 80, 0, 0),
							0, 0));
					// jButton2.setText("SMS");
					jButtonSMS.setToolTipText("SMS");
					jButtonSMS.setIcon(UIImages.getSmsImage());
					jButtonSMS.addActionListener(this);

				}
				{
					jLabelEventCode = new JLabel();
					jPanel.add(jLabelEventCode, new GridBagConstraints(2, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.SOUTHWEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelEventCode.setText("Event Code :");
				}
				{
					jLabelExternalSys = new JLabel();
					jPanel.add(jLabelExternalSys, new GridBagConstraints(2, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelExternalSys.setText("External System :");
				}
				{
					jLabelDescription = new JLabel();
					jPanel.add(jLabelDescription, new GridBagConstraints(2, 2, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelDescription.setText("Description :");
				}
				{
					jLabelFunctionName = new JLabel();
					jPanel.add(jLabelFunctionName, new GridBagConstraints(2, 3, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelFunctionName.setText("Function Name :");
				}
				{
					jLabelTemplateName = new JLabel();
					jPanel.add(jLabelTemplateName, new GridBagConstraints(2, 4, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelTemplateName.setText("Template Name :");
				}
				{
					jLabelFunctionType = new JLabel();
					jPanel.add(jLabelFunctionType, new GridBagConstraints(4, 3, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelFunctionType.setText("Function Type :");
				}
				{
					jLabelTemplatePath = new JLabel();
					jPanel.add(jLabelTemplatePath, new GridBagConstraints(4, 4, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelTemplatePath.setText("Template Path :");
				}
				{
					jLabelFileAttach = new JLabel();
					jPanel.add(jLabelFileAttach, new GridBagConstraints(2, 5, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelFileAttach.setText("File Attach :");
				}
				{
					jLabelAttachType = new JLabel();
					jPanel.add(jLabelAttachType, new GridBagConstraints(2, 6, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelAttachType.setText("Attach Type :");
				}
				{
					jLabelEventCode0 = new JLabel();
					jPanel.add(jLabelEventCode0, new GridBagConstraints(2, 7, 1, 1,
							0.0, 0.0, GridBagConstraints.WEST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jLabelEventCode0.setText("Attach Path :");
				}
				{
					jButtonDBConfig = new JButton();
					jPanel.add(jButtonDBConfig, new GridBagConstraints(4, 8,
							1, 1, 0.0, 0.0, GridBagConstraints.EAST,
							GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
							0));
					jButtonDBConfig.setText("Ext DB Config");
					jButtonDBConfig.setToolTipText("External DB Config");
					jButtonDBConfig.addActionListener(this);
				}
			}
			pack();
			this.setSize(530, 468);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == jButtonEmail) {
			if (ChilEmailInst == null) {
				System.out.println("email_Priority:" + emailPriority);
				ChilEmailInst = new ChildEmail();
				ChilEmailInst.setVisible(true);
			} else {
				ChilEmailInst.setValues(emailName, emailTo, emailFromName,
						emailCC, emailBCC, emailSubject, emailPriority);
				ChilEmailInst.show();
			}
		}
		else if (ae.getSource() == jButtonDBConfig) {
			if (ChildDBConfigInst == null) {
				ChildDBConfigInst = new ChildDBConfig();
				ChildDBConfigInst.setVisible(true);
			} else {
				ChildDBConfigInst.setValues(dbDBServerPort, dbDBServerIP, dbDBName, dbDBUserName, dbDBUserPWD, dbDBSID, dbDeliveryFreq);
				ChildDBConfigInst.show();
			}
		}
		else if (ae.getSource() == jButtonSMS) {
			if (ChildSMSInst == null) {
				ChildSMSInst = new ChildSMS();
				ChildSMSInst.setVisible(true);
			} else {
				ChildSMSInst.setValues(smsToName, smsFromName, smsCellNo);
				ChildSMSInst.show();
			}
		}
		else if (ae.getSource() == jButtonClear) {
			jTextEventCode.setText("");
			jTextExtSystem.setText("");
			jTextFunctionName.setText("");
			jTextFunctionType.setText("");
			jTextTemplateName.setText("");
			jTextTemplatePath.setText("");
			jTextAttachType.setText("");
			jTextAttachPath.setText("");
			jTextAreaDescription.setText("");
			jCheckFileAttach.setSelected(false);
		}
		else if (ae.getSource() == jButtonSave) {
			boolean mandatoryValue = true;
			mandatoryValue = checkMandatory();
			if( mandatoryValue ){
				System.out.println("1111111111111");
			MailBean mailBeanInst = new MailBean();
			mailBeanInst.setAttachPath(jTextAttachPath.getText().trim());
			mailBeanInst.setAttachType(jTextAttachType.getText().trim());
			mailBeanInst.setDbDBName(dbDBName);
			mailBeanInst.setDbDBServerIP(dbDBServerIP);
			mailBeanInst.setDbDBServerPort(dbDBServerPort);
			mailBeanInst.setDbDBSID(dbDBSID);
			mailBeanInst.setDbDBUserName(dbDBUserName);
			mailBeanInst.setDbDBUserPWD(dbDBUserPWD);
			mailBeanInst.setDbDeliveryFreq(dbDeliveryFreq);
			mailBeanInst.setDescription(jTextAreaDescription.getText().trim());
			mailBeanInst.setEmailBCC(emailBCC);
			mailBeanInst.setEmailCC(emailCC);
			mailBeanInst.setEmailFromName(emailFromName);
			mailBeanInst.setEmailName(emailName);
			mailBeanInst.setEmailPriority(emailPriority);
			mailBeanInst.setEmailSubject(emailSubject);
			mailBeanInst.setEmailTo(emailTo);
			mailBeanInst.setEventCode(jTextEventCode.getText().trim());
			mailBeanInst.setExternalSystem(jTextExtSystem.getText().trim());
			mailBeanInst.setFileAttach(jCheckFileAttach.isSelected());
			mailBeanInst.setFunctionName(jTextFunctionName.getText().trim());
			mailBeanInst.setFunctionType(jTextFunctionType.getText().trim());
			mailBeanInst.setSmsCellNo(smsCellNo);
			mailBeanInst.setSmsFromName(smsFromName);
			mailBeanInst.setSmsToName(smsToName);
			mailBeanInst.setTemplateName(jTextTemplateName.getText().trim());
			mailBeanInst.setTemplatePath(jTextTemplatePath.getText().trim());
//			MailDAO mailDAO = new MailDAO();
			boolean returnType = MailDAO.passMailValues(mailBeanInst);
			System.out.println("2222222222222");
			this.dispose();
			}
			else
				JOptionPane.showMessageDialog(this,"Please Enter Mandatory Fileds");
				
		}

	}
	boolean checkMandatory(){
		boolean mandatoryValue = true;
		String eventCode = jTextEventCode.getText().trim();
		String externalSystem = jTextExtSystem.getText().trim();
	//	String description = jTextAreaDescription.getText().trim();
		String functionName = jTextFunctionName.getText().trim();
		String functionType = jTextFunctionType.getText().trim();
		String templateName = jTextTemplateName.getText().trim();
		String templatePath = jTextTemplatePath.getText().trim();
		//boolean isFileAttach = jCheckFileAttach.isSelected();
		String attachType = jTextAttachType.getText().trim();
		String attachPath = jTextAttachPath.getText().trim();
		
		if( eventCode.equals("") || externalSystem.equals("") || functionName.equals("") 
				|| functionType.equals("") || templateName.equals("") || templatePath.equals("")  
				|| attachType.equals("") || attachPath.equals(""))
			mandatoryValue = true;
		
		return mandatoryValue;
	}
	public void setEmailValues(String email_Name, String email_To,
			String email_FromName, String email_CC, String email_BCC,
			String email_Subject, String email_Priority) {
		emailName = email_Name;
		emailTo = email_To;
		emailFromName = email_FromName;
		emailCC = email_CC;
		emailBCC = email_BCC;
		emailSubject = email_Subject;
		emailPriority = email_Priority;
	}

	public void setSmsValues(String sms_ToName, String sms_FromName,
			String sms_CellNo) {
		smsToName = sms_ToName;
		smsFromName = sms_FromName;
		smsCellNo = sms_CellNo;
	}

	public void setDBValues(String db_DBServerPort, String db_DBServerIP, 
			String db_DBName, String db_DBUserName, String db_DBUserPWD, 
			String db_DBSID, String db_DeliveryFreq )
	 {
		 dbDBServerPort = db_DBServerPort;
		 dbDBServerIP = db_DBServerIP;
		 dbDBName = db_DBName;	
		 dbDBUserName = db_DBUserName;
		 dbDBUserPWD = db_DBUserPWD;
		 dbDBSID = db_DBSID;	
		 dbDeliveryFreq = db_DeliveryFreq;
	 }
	
	
}
