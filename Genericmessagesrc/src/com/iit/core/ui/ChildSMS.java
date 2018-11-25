package com.iit.core.ui;

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

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ChildSMS extends javax.swing.JFrame implements ActionListener {
	private JToolBar jToolBar;
	private JPanel jPanel;
	private JLabel jLabelCellNo;
	private JButton jButtonSave;
	private JButton jButtonClear;
	private JTextField jTextCellNo;
	private JTextField jTextFromName;
	private JTextField jTextToName;
	private JLabel jLabelFromName;
	private JLabel jLabelToName;

	Mail parentMailInst = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		ChildSMS inst = new ChildSMS();
		inst.setVisible(true);
	}
	
	public ChildSMS() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jToolBar = new JToolBar();
				getContentPane().add(jToolBar);
				jToolBar.setBounds(0, 0, 392, 28);
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
				jPanelLayout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.1};
				jPanelLayout.rowHeights = new int[] {41, 31, 33, 38, 7};
				jPanelLayout.columnWeights = new double[] {0.0, 0.0, 0.1, 0.1};
				jPanelLayout.columnWidths = new int[] {17, 109, 7, 7};
				jPanel.setLayout(jPanelLayout);
				jPanel.setBackground(new java.awt.Color(192,192,192));
				getContentPane().add(jPanel);
				jPanel.setBounds(7, 28, 392, 238);

				{
					jLabelToName = new JLabel();
					jPanel.add(jLabelToName, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelToName.setText("To Name :");
				}
				{
					jLabelFromName = new JLabel();
					jPanel.add(jLabelFromName, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelFromName.setText("From Name :");
				}
				{
					jLabelCellNo = new JLabel();
					jPanel.add(jLabelCellNo, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jLabelCellNo.setText("Cell No :");
				}

				{
					jTextToName = new JTextField();
					jPanel.add(jTextToName, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextToName.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextFromName = new JTextField();
					jPanel.add(jTextFromName, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextFromName.setPreferredSize(new java.awt.Dimension(120, 20));
				}
				{
					jTextCellNo = new JTextField();
					jPanel.add(jTextCellNo, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
					jTextCellNo.setPreferredSize(new java.awt.Dimension(120, 20));
					jTextCellNo.setDocument(new NumericDocument(12));
				}
			}
			pack();
			this.setSize(400, 244);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void setValues(String sms_ToName,String sms_FromName, String sms_CellNo)
	{
		jTextToName.setText(sms_ToName);
		jTextFromName.setText(sms_FromName);
		jTextCellNo.setText(sms_CellNo);
	}
	 public void actionPerformed(ActionEvent ae){
		 if (ae.getSource() == jButtonClear) 
		 {
			 jTextToName.setText("");
			 jTextFromName.setText("");
			 jTextCellNo.setText("");
		 }
		 else if (ae.getSource() == jButtonSave) {
			 String sms_ToName = jTextToName.getText().trim();
			 String sms_FromName = jTextFromName.getText().trim();
			 String sms_CellNo = jTextCellNo.getText().trim();
			 parentMailInst = new Mail();
			 parentMailInst.setSmsValues( sms_ToName, sms_FromName, sms_CellNo );
			 this.dispose(); 
		 }
	 }
}

	/**
	 * This class is used to allow only numberic values  while entering into TextField;
	 */
	class NumericDocument extends PlainDocument {
		 int maxChars;
		public  NumericDocument(int chars){
			maxChars=chars;
		}
	    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
	        String modified = "";
	        if(getLength() < maxChars){
		      
		        for( int n = 0; n < str.length(); ++n ) {
		            char c = str.charAt(n);
		            if( Character.isDigit(c) ) {
		                modified += c;
		            }
		            else {
		                Toolkit.getDefaultToolkit().beep();
		            }
		        }
		        super.insertString(offs, modified, a);
		    }
	    }

	}

