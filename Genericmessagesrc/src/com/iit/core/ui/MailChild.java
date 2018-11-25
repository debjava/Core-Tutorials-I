package com.iit.core.ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;


public class MailChild extends javax.swing.JFrame implements ActionListener{
	private JToolBar jToolBar1;
	private JPanel jPanel1;
	private JTextField jTextField6;
	private JLabel jLabel10;
	private JLabel jLabel4;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField jTextField8;
	private JTextField jTextField7;
	private JCheckBox jCheckBox1;
	private JTextField jTextField5;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextArea jTextArea1;
	private JTextField jTextField2;
	//private JTextField jTextField1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		Mail inst = new Mail();
		inst.setVisible(true);
	}
	
	public MailChild() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jToolBar1 = new JToolBar();
				getContentPane().add(jToolBar1, BorderLayout.NORTH);
				jToolBar1.setPreferredSize(new java.awt.Dimension(522, 29));
				{
					jButton3 = new JButton();
					jToolBar1.add(jButton3);
					//jButton3.setText("Save");
					jButton3.setToolTipText("Save");
					jButton3.setIcon(UIImages.getSaveImage());
				}
				{
					jButton4 = new JButton();
					jToolBar1.add(jButton4);
					//jButton4.setText("Clear");
					jButton4.setToolTipText("Clear");
					jButton4.setIcon(UIImages.getClearImage());
				}
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				GridBagLayout jPanel1Layout = new GridBagLayout();
				jPanel1Layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
				jPanel1Layout.rowHeights = new int[] {44, 34, 31, 31, 32, 29, 31, 31, 105, 4};
				jPanel1Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
				jPanel1Layout.columnWidths = new int[] {-1, 29, 113, 158, 105, 7};
				FlowLayout jPanel2Layout = new FlowLayout();
				jPanel1.setBackground(new java.awt.Color(192,192,192));
				jPanel1.setLayout(jPanel1Layout);
//				{
//					jTextField1 = new JTextField();
//					jPanel1.add(jTextField1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//					jTextField1.setPreferredSize(new java.awt.Dimension(50, 20));
//				}
				{
					jTextField2 = new JTextField();
					jPanel1.add(jTextField2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField2.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextArea1 = new JTextArea();
					jPanel1.add(jTextArea1, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					jTextField2.setPreferredSize(new java.awt.Dimension(50, 20));
				}
				{
					jTextField3 = new JTextField();
					jPanel1.add(jTextField3, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField3.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextField4 = new JTextField();
					jPanel1.add(jTextField4, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField4.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextField5 = new JTextField();
					jPanel1.add(jTextField5, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField5.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextField6 = new JTextField();
					jPanel1.add(jTextField6, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField6.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jCheckBox1 = new JCheckBox();
					jPanel1.add(jCheckBox1, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					jTextField7 = new JTextField();
					jPanel1.add(jTextField7, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField7.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jTextField8 = new JTextField();
					jPanel1.add(jTextField8, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextField8.setPreferredSize(new java.awt.Dimension(80, 20));
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1, new GridBagConstraints(
						3,
						8,
						1,
						1,
						0.0,
						0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0),
						0,
						0));
					jButton1.setToolTipText("E-Mail");
					jButton1.setIcon(UIImages.getEmailImage());
					jButton1.addActionListener(this);
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					//jButton2.setText("SMS");
					jButton2.setToolTipText("SMS");
					jButton2.setIcon(UIImages.getSmsImage());
					jButton2.addActionListener(this);
					
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel1.setText("Event Code");
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel2.setText("External System");
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel3.setText("Description");
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel4.setText("Function Name");
				}
				{
					jLabel5 = new JLabel();
					jPanel1.add(jLabel5, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel5.setText("Template Name");
				}
				{
					jLabel6 = new JLabel();
					jPanel1.add(jLabel6, new GridBagConstraints(
						4,
						3,
						1,
						1,
						0.0,
						0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0),
						0,
						0));
					jLabel6.setText("Function Type");
				}
				{
					jLabel7 = new JLabel();
					jPanel1.add(jLabel7, new GridBagConstraints(
						4,
						4,
						1,
						1,
						0.0,
						0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0),
						0,
						0));
					jLabel7.setText("Template Path");
				}
				{
					jLabel8 = new JLabel();
					jPanel1.add(jLabel8, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel8.setText("File Attach");
				}
				{
					jLabel9 = new JLabel();
					jPanel1.add(jLabel9, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel9.setText("Attach Type");
				}
				{
					jLabel10 = new JLabel();
					jPanel1.add(jLabel10, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabel10.setText("Attach Path");
				}
			}
			pack();
			this.setSize(530, 515);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 public void actionPerformed(ActionEvent ae){
	  
		}
	
}
