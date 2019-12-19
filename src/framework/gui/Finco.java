package framework.gui;


import framework.account.AbstractAccount;
import framework.controller.AccountController;
import framework.service.AccountService;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/***
 * A basic JFC based application.
 ***/
public class Finco extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
	boolean newaccount;
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	Finco myframe;
	private Object rowdata[];

	public Finco() {
		myframe = this;

		setTitle("Finco Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Ch/S");
		model.addColumn("Balance");
		rowdata = new Object[8];
		newaccount = false;


		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

		JButton_PerAC.setText("Add Account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24, 20, 192, 33);
//		JButton_CompAC.setText("Add company account");
//		JButton_CompAC.setActionCommand("jbutton");
//		JPanel1.add(JButton_CompAC);
//		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
//		JButton_Addinterest.setBounds(448,20,106,33);
//		JButton_Addinterest.setText("Add interest");
//		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468, 248, 96, 31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

		refreshTable();

	}


	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[]) {
		try {
			// Add the following code if you want the Look and Feel
			// to be set to the Look and Feel of the native system.

			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
			}

			//Create a new instance of our application's frame, and make it visible.
			(new Finco()).setVisible(true);
		} catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	protected javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	protected javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	protected javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Addinterest = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	void exitApplication() {
		try {
			this.setVisible(false);    // hide the Frame
			this.dispose();            // free the system resources
			System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == Finco.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				   JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	//When the Exit button is pressed this code gets executed
	//this will exit from the system
	void JButtonExit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	protected void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 JDialog_AddAcc type object is for adding personal information
		 construct a JDialog_AddAcc type object
		 set the boundaries and show it 
		*/

		JDialog_AddAcc pac = new JDialog_AddAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {
			// add row to table
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "P";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			refreshTable();
			newaccount = false;
		}


	}

	protected void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/

		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newaccount) {
//            // add row to table
//            rowdata[0] = accountnr;
//            rowdata[1] = clientName;
//            rowdata[2] = city;
//            rowdata[3] = "C";
//            rowdata[4] = accountType;
//            rowdata[5] = "0";
//            model.addRow(rowdata);
//            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			refreshTable();
			newaccount = false;
		}

	}

	protected void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			//Show the dialog for adding deposit amount for the current mane
			JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			// compute new amount
			// compute new amount
			double deposit = Double.parseDouble(amountDeposit);
			double currentamount = Double.parseDouble(model.getValueAt(selection, 5).toString());
			//double currentamount = Double.parseDouble(samount);
			double newamount = currentamount + deposit;
			model.setValueAt(newamount, selection, 5);
		}


	}

	protected void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event) {
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			String accnr = (String) model.getValueAt(selection, 0);

			//Show the dialog for adding withdraw amount for the current mane
			JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			// compute new amount
			double withdraw = Double.parseDouble(amountDeposit);
			double currentamount = Double.parseDouble(model.getValueAt(selection, 5).toString());
			//double currentamount = Double.parseDouble(samount);
			double newamount = currentamount - withdraw;
			model.setValueAt(newamount, selection, 5);
			if (newamount < 0) {
				JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
			}
		}


	}

	protected void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

	}

	//refresh table
	void refreshTable() {
		model.setRowCount(0);
		AccountController auc = new AccountController(new AccountService());
		List<AbstractAccount> accounts = auc.getAllAccounts();
		for (AbstractAccount acc : accounts) {
			if (acc != null) {
				rowdata[0] = acc.getAccountNbr();
				if (acc.getUser() != null) {
					rowdata[1] = acc.getUser().getName();
					rowdata[2] = acc.getUser().getCity();
					rowdata[3] = acc.getUser().getUserType();
					rowdata[4] = acc.getAccTypes();
					rowdata[5] = acc.getCurrentBalance();
					model.addRow(rowdata);
				}
			}
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		}
	}
}
