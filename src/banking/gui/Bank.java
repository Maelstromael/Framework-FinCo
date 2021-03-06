package banking.gui;

import banking.factory.BankAccountFactory;
import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.account.Account;
import framework.controller.AccountController;
import framework.controller.UserController;
import framework.factory.AccountFactory;
import framework.gui.*;
import framework.service.AccountService;
import framework.service.UserService;
import framework.user.AbstractUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class Bank extends Finco {

    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    //private JScrollPane JScrollPane1;
    Bank myframe;
    private Object rowdata[];
    private String amountDeposit;

    public Bank(){

        setTitle("Bank Application");

        /*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        myframe = this;
       // super.JScrollPane1.setViewport(null);
        //JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();

        model.addColumn("Account");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("State");
        model.addColumn("Zip");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowdata = new Object[8];
        newaccount = false;

        JTable1 = new JTable(model);
        super.JTable1 = this.JTable1;

        super.JScrollPane1.getViewport().add(JTable1);

        JButton_PerAC.setText("Add Personal Account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
    	JButton_CompAC.setBounds(240,20,192,33);

		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);

		bankDb();
		refreshTable();

    }

    private void bankDb(){
        UserController uc = new UserController(new UserService());
        AbstractUser user1  = uc.createUser(UserType.PERSON,"Adeola Adeleke", "1000 N Str", "Fairfield", "Iowa", "aadeola@mum.edu", "52557", null);
        AbstractUser user2  = uc.createUser(UserType.PERSON,"Ny Andriantsoa", "1000 N Str", "Fairfield", "Iowa", "aadeola@mum.edu", "52557", null);
        AbstractUser user3  = uc.createUser(UserType.PERSON,"Lucky Gilbert", "1000N Str", "Fairfield", "Iowa", "aadeola@mum.edu", "52557", null);
       // AccountController auc = new AccountController(new AccountService());
        if(user1 != null) {
            AbstractAccount acc = uc.createAccount(AccountTypes.CHECKINGS, "627468", user1, BankAccountFactory.getInstance());
            if (acc != null) {
                System.err.println("User 1: Account Creation Successful");
            }
        }

        if(user2 != null) {
            AbstractAccount acc = uc.createAccount(AccountTypes.SAVINGS, "535353", user2, BankAccountFactory.getInstance());
            if (acc != null) {
                System.err.println("User 2: Account Creation Successful");
            }
        }
        if(user3 != null) {
            AbstractAccount acc = uc.createAccount(AccountTypes.CHECKINGS, "24424", user3, BankAccountFactory.getInstance());
            if (acc != null) {
                System.err.println("User 3: Account Creation Successful");
                //auc.deposit("24424", Double.parseDouble("6766"));
            }
        }

    }

    @Override
    protected void JButtonPerAC_actionPerformed(ActionEvent event) {
        JDialog_AddAcc pac = new AddPersonDialog(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        System.err.println("newaccout : " + newaccount);

        if (newaccount) {
            refreshTable();
            newaccount = false;
        }

    }

    @Override
    protected void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {

        JDialog_AddCompAcc pac = new AddCompanyDialog(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        System.err.println("newaccout : " + newaccount);

        if (newaccount) {
            refreshTable();
            newaccount = false;
        }



    }

    @Override
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
            /*double deposit = Double.parseDouble(amountDeposit);
            double currentamount = Double.parseDouble(model.getValueAt(selection, 5).toString());
            //double currentamount = Double.parseDouble(samount);
            double newamount = currentamount + deposit;
            model.setValueAt(newamount, selection, 5);*/
            refreshTable();
        }


    }

    @Override
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
            /*double withdraw = Double.parseDouble(amountDeposit);
            double currentamount = Double.parseDouble(model.getValueAt(selection, 5).toString());
            //double currentamount = Double.parseDouble(samount);
            double newamount = currentamount - withdraw;
            model.setValueAt(newamount, selection, 5);
            if (newamount < 0) {
                JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }*/

            refreshTable();
        }
    }

    @Override
    protected void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        int res = JOptionPane.showConfirmDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            AccountController actr = new AccountController(new AccountService());
            actr.addInterest();

            refreshTable();
        }
    }


    protected void refreshTable() {
        if(model != null) {
            model.setRowCount(0);
            AccountController auc = new AccountController(new AccountService());
            List<Account> accounts = auc.getAllAccounts();
            System.err.println(accounts.toString());
            for (AbstractAccount acc : accounts) {
                if (acc != null) {
                    rowdata[0] = acc.getAccountNbr();
                    if (acc.getUser() != null) {
                        rowdata[1] = acc.getUser().getName();
                        rowdata[2] = acc.getUser().getCity();
                        rowdata[3] = acc.getUser().getState();
                        rowdata[4] = acc.getUser().getZip();
                        rowdata[5] = acc.getUser().getUserType();
                        rowdata[6] = acc.getAccTypes();
                        rowdata[7] = acc.getCurrentBalance();
                        model.addRow(rowdata);
                    }
                }
                JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            }
        }
    }

}
