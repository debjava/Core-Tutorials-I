package com.iit.core.ui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import javax.swing.WindowConstants;


public class ChildDBConfig extends javax.swing.JFrame implements ActionListener{
	private JToolBar jToolBar;
	private JTextField jTextDBSID;
	private JTextField jTextDeliveryStatus;
	private JTextField jTextDBUserPwd;
	private JTextField jTextDBUserName;
	private JTextField jTextDBName;
	private JPanel jPanel;
	private JTextField jTextDBServerIP;
	private JTextField jTextDBServerPort;
	private JLabel jLabelDeliveryFrequency;
	private JLabel jLabelDBSID;
	private JLabel jLabelDBUserPwd;
	private JLabel jLabelDBUserName;
	private JLabel jLabelDBName;
	private JLabel jLabelDBServerIP;
	private JLabel jLabelDBServerPort;
	private JButton jButtonClear;
	private JButton jButtonSave;
	Mail parentMailInst = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		ChildDBConfig inst = new ChildDBConfig();
		inst.setVisible(true);
	}
	
	public ChildDBConfig() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jToolBar = new JToolBar();
				getContentPane().add(jToolBar, BorderLayout.NORTH);
				jToolBar.setPreferredSize(new java.awt.Dimension(392, 23));
				{
					jButtonSave = new JButton();
					jToolBar.add(jButtonSave);
					jButtonSave.setToolTipText("Save");
					jButtonSave.setIcon(UIImages.getSaveImage());
					jButtonSave.addActionListener(this);
				}
				
				{
					jButtonClear = new JButton();
					jToolBar.add(jButtonClear);
					jButtonClear.setToolTipText("Clear");
					jButtonClear.setIcon(UIImages.getClearImage());
					jButtonClear.addActionListener(this);
				}
			}
			{
				jPanel = new JPanel();
				GridBagLayout jPanelLayout = new GridBagLayout();
				jPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
				jPanelLayout.rowHeights = new int[] {25, 26, 27, 26, 26, 25, 26, 28, 20};
				jPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
				jPanelLayout.columnWidths = new int[] {17, 131, 7, 7};
				jPanel.setLayout(jPanelLayout);
				getContentPane().add(jPanel, BorderLayout.CENTER);
				jPanel.setPreferredSize(new java.awt.Dimension(392, 341));
				jPanel.setBackground(new java.awt.Color(192,192,192));
				jPanel.setSize(392, 350);
				{
					jLabelDBServerPort = new JLabel();
					jPanel.add(jLabelDBServerPort, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDBServerPort.setText("DB Server Port : ");
				}
				{
					jLabelDBServerIP = new JLabel();
					jPanel.add(jLabelDBServerIP, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDBServerIP.setText("DBServerIP :");
				}
				{
					jLabelDBName = new JLabel();
					jPanel.add(jLabelDBName, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDBName.setText("DB Name :");
				}
				{
					jLabelDBUserName = new JLabel();
					jPanel.add(jLabelDBUserName, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDBUserName.setText("DB User Name :");
				}
				{
					jLabelDBUserPwd = new JLabel();
					jPanel.add(jLabelDBUserPwd, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDBUserPwd.setText("DB User Pwd :");
				}
				{
					jLabelDBSID = new JLabel();
					jPanel.add(jLabelDBSID, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDBSID.setText("DB SID :");
				}
				{
					jLabelDeliveryFrequency = new JLabel();
					jPanel.add(jLabelDeliveryFrequency, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelDeliveryFrequency.setText("Delivery Frequency :");
				}
				{
					jTextDBServerPort = new JTextField();
					jPanel.add(jTextDBServerPort, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDBServerPort.setText("jTextDBServerPort");
					jTextDBServerPort.setPreferredSize(new java.awt.Dimension(40, 20));
				}
				{
					jTextDBServerIP = new JTextField();
					jPanel.add(jTextDBServerIP, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDBServerIP.setText("jTextDBServerIP");
					jTextDBServerIP.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextDBName = new JTextField();
					jPanel.add(jTextDBName, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDBName.setText("jTextDBName");
					jTextDBName.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextDBUserName = new JTextField();
					jPanel.add(jTextDBUserName, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDBUserName.setText("jTextDBUserName");
					jTextDBUserName.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextDBUserPwd = new JTextField();
					jPanel.add(jTextDBUserPwd, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDBUserPwd.setText("jTextDBUserPwd");
					jTextDBUserPwd.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextDBSID = new JTextField();
					jPanel.add(jTextDBSID, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDBSID.setText("jTextDBSID");
					jTextDBSID.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextDeliveryStatus = new JTextField();
					jPanel.add(jTextDeliveryStatus, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jTextDeliveryStatus.setText("jTextDeliveryStatus");
					jTextDeliveryStatus.setPreferredSize(new java.awt.Dimension(20, 20));
				}
			}
			pack();
			this.setSize(400, 295);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void setValues( String db_DBServerPort, String db_DBServerIP, 
			String db_DBName, String db_DBUserName, String db_DBUserPWD, 
			String db_DBSID, String db_DeliveryFreq ){
		jTextDBServerPort.setText(db_DBServerPort);
		jTextDBServerIP.setText(db_DBServerIP);
		jTextDBName.setText(db_DBName);
		jTextDBUserName.setText(db_DBUserName);
		jTextDBUserPwd.setText(db_DBUserPWD);
		jTextDBSID.setText(db_DBSID);
		jTextDeliveryStatus.setText(db_DeliveryFreq);
	}
	 public void actionPerformed(ActionEvent ae){
		 if(ae.getSource()==jButtonClear){
			 jTextDBServerPort.setText("");
			 jTextDBServerIP.setText("");
			 jTextDBName.setText("");
			 jTextDBUserName.setText(""); 
			 jTextDBUserPwd.setText("");
			 jTextDBSID.setText("");
			 jTextDeliveryStatus.setText("");			 
		 }
		 else if (ae.getSource() == jButtonSave) {
			 
			 String db_DBServerPort = jTextDBServerPort.getText().trim();
			 String db_DBServerIP = jTextDBServerIP.getText().trim();
			 String db_DBName = jTextDBName.getText().trim();
			 String db_DBUserName = jTextDBUserName.getText().trim();
			 String db_DBUserPWD = jTextDBUserPwd.getText().trim();
			 String db_DBSID = jTextDBSID.getText().trim();
			 String db_DeliveryFreq = jTextDeliveryStatus.getText().trim();
			 parentMailInst = new Mail();
			 parentMailInst.setDBValues( db_DBServerPort, db_DBServerIP, db_DBName, db_DBUserName, db_DBUserPWD, db_DBSID, db_DeliveryFreq  );
			 this.dispose(); 
		 }
	 }

}
