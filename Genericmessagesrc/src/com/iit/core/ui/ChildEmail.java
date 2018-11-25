package com.iit.core.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.WindowConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;

public class ChildEmail extends javax.swing.JFrame implements ActionListener{
	private JToolBar jToolBar;
	private JPanel jPanel;
	
	private JLabel jLabelFromName;
	private JLabel jLabelPriority;
	private JTextField jTextBCC;
	private JButton jButtonClear;
	private JButton jButtonSave;
	private JComboBox jComboPriority;
	private JTextField jTextSubject;
	private JTextField jTextCC;
	private JTextField jTextFromName;
	private JTextField jTextTo;
	private JTextField jTextName;
	
	private JLabel jLabelSubject;
	private JLabel jLabelBCC;
	private JLabel jLabelCC;
	private JLabel jLabelTo;
	private JLabel jLabelName;
	
	
	public static Mail parentMailInst = null;
	private static final String EMAIL_PATTERN1 =".+@.+\\.[a-z]+";
	private static final String EMAIL_PATTERN2 =".+@.+\\.[A-Z]+";
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		ChildEmail inst = new ChildEmail();
		inst.setVisible(true);
	}
	
	public ChildEmail() {
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
				getContentPane().add(jPanel, BorderLayout.CENTER);
				GridBagLayout jPanelLayout = new GridBagLayout();
				jPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
				jPanelLayout.rowHeights = new int[] {58, 31, 31, 32, 30, 31, 29, 20};
				jPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.1};
				jPanelLayout.columnWidths = new int[] {-1, 29, 113, 158, 105, 7};
				
				jPanel.setBackground(new java.awt.Color(192,192,192));
				jPanel.setLayout(jPanelLayout);
				jPanel.setPreferredSize(new java.awt.Dimension(476, 300));
				jPanel.setSize(450, 452);
//				{
//					jLabel1 = new JLabel();
//					jPanel.add(jLabel1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//					jLabel1.setText("Event Code :");
//				}
				{
					jLabelName = new JLabel();
					jPanel.add(jLabelName, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelName.setText("Name :");
				}
				{
					jLabelTo = new JLabel();
					jPanel.add(jLabelTo, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelTo.setText("To :");
				}
				{
					jLabelFromName = new JLabel();
					jPanel.add(jLabelFromName, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelFromName.setText("From Name :");
				}
				{
					jLabelCC = new JLabel();
					jPanel.add(jLabelCC, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelCC.setText("CC :");
				}
				{
					jLabelBCC = new JLabel();
					jPanel.add(jLabelBCC, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelBCC.setText("BCC :");
				}
				{
					jLabelSubject = new JLabel();
					jPanel.add(jLabelSubject, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelSubject.setText("Subject :");
				}
				{
					jLabelPriority = new JLabel();
					jPanel.add(jLabelPriority, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelPriority.setText("Priority :");
				}
//				{
//					jTextField1 = new JTextField();
//					jPanel.add(jTextField1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
//					jTextField1.setPreferredSize(new java.awt.Dimension(80, 20));
//				}
				{
					jTextName = new JTextField();
					jPanel.add(jTextName, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextName.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextTo = new JTextField();
					jPanel.add(jTextTo, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextTo.setPreferredSize(new java.awt.Dimension(160, 20));
					jTextTo.addFocusListener(new FocusAdapter(){
						public void focusLost(FocusEvent fe)
						{
							String emailid=jTextTo.getText();
							if(fe.getOppositeComponent()!=null)
							{
								if(!(emailid.equals("")))
								{
									if(!(validateEmail(emailid)))
									{
										JOptionPane.showMessageDialog(jTextTo,"Invalid E-Mail ID");
										jTextTo.setText("");
									}
								}
							}
						}
					});
				}
				{
					jTextFromName = new JTextField();
					jPanel.add(jTextFromName, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextFromName.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextCC = new JTextField();
					jPanel.add(jTextCC, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextCC.setPreferredSize(new java.awt.Dimension(160, 20));
					jTextCC.addFocusListener(new FocusAdapter(){
						public void focusLost(FocusEvent fe)
						{
							String emailid=jTextCC.getText();
							if(fe.getOppositeComponent()!=null)
							{
								if(!(emailid.equals("")))
								{
									if(!(validateEmail(emailid)))
									{
										JOptionPane.showMessageDialog(jTextCC,"Invalid E-Mail ID");
										jTextCC.setText("");
									}
								}
							}
						}
					});
				}
				{
					jTextBCC = new JTextField();
					jPanel.add(jTextBCC, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextBCC.setPreferredSize(new java.awt.Dimension(160, 20));
					jTextBCC.addFocusListener(new FocusAdapter(){
						public void focusLost(FocusEvent fe)
						{
							String emailid=jTextBCC.getText();
							if(fe.getOppositeComponent()!=null)
							{
								if(!(emailid.equals("")))
								{
									if(!(validateEmail(emailid)))
									{
										JOptionPane.showMessageDialog(jTextBCC,"Invalid E-Mail ID");
										jTextBCC.setText("");
									}
								}
							}
						}
					});
				}
				{
					jTextSubject = new JTextField();
					jPanel.add(jTextSubject, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextSubject.setPreferredSize(new java.awt.Dimension(160, 20));
				}
				{
					ComboBoxModel jComboPriorityModel = new DefaultComboBoxModel(
						new String[] { "Normal", "High", "Low" });
					jComboPriority = new JComboBox();
					jPanel.add(jComboPriority, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jComboPriority.setModel(jComboPriorityModel);
				}
			}
			pack();
			this.setSize(484, 372);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void setValues(String email_Name, String email_To, String email_FromName, String email_CC, String email_BCC, String email_Subject, String email_Priority){
		jTextName.setText(email_Name);
		jTextTo.setText(email_To);
		jTextFromName.setText(email_FromName);
		jTextCC.setText(email_CC);
		jTextBCC.setText(email_BCC);
		jTextSubject.setText(email_Subject);
		jComboPriority.setSelectedItem(email_Priority);
	}
	 public void actionPerformed(ActionEvent ae){
		 
		 if (ae.getSource() == jButtonClear) {
		//	 jTextField1.setText("");
			 jTextName.setText("");
			 jTextTo.setText("");
			 jTextFromName.setText("");
			 jTextCC.setText("");
			 jTextBCC.setText("");
			 jTextSubject.setText("");
			 jComboPriority.setSelectedItem("Normal");
			 }
		 else if (ae.getSource() == jButtonSave) {
			 String email_Name = jTextName.getText().trim();
			 String email_To = jTextTo.getText().trim();
			 String email_FromName = jTextFromName.getText().trim();
			 String email_CC = jTextCC.getText().trim();
			 String email_BCC = jTextBCC.getText().trim();
			 String email_Subject = jTextSubject.getText().trim();
			 String email_Priority = jComboPriority.getSelectedItem().toString();
			 parentMailInst = new Mail();
			 parentMailInst.setEmailValues(email_Name,email_To,email_FromName,email_CC,email_BCC,email_Subject,email_Priority);
			 this.dispose();
				
		}
	 }
	 
	 public static boolean validateEmail(String emailId){
		
			boolean matchFound=false;
			String[] str = emailId.split(",");
			try
			{
				//	Set the email pattern string
				Pattern p1 = Pattern.compile(EMAIL_PATTERN1);
				for(int i = 0; i < str.length; i++){
					//Match the given string with the pattern
					Matcher m1 = p1.matcher(str[i]);
					//check whether match is found 
					matchFound = m1.matches();
					if(!matchFound){
						Pattern p2 = Pattern.compile(EMAIL_PATTERN2);
						Matcher m2 = p2.matcher(str[i]);
						matchFound = m2.matches();
						if(!matchFound)
							break;
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		return matchFound;
		}
}
