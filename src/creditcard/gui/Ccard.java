package creditcard.gui;

import creditcard.account.AbstractCreditCardAccount;
import creditcard.service.CreditAccountService;
import framework.account.AbstractAccount;
import framework.controller.AccountController;
import framework.gui.*;
import framework.service.AccountService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class Ccard extends Finco {

    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    //private JScrollPane JScrollPane1;
    Ccard myframe;
    private Object rowdata[];
    private String amountDeposit;

    public Ccard(){

        setTitle("Credit Card Application");

        /*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        myframe = this;
       // super.JScrollPane1.setViewport(null);
        //JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("CC number");
        model.addColumn("Exp Date");
        model.addColumn("Type");
        model.addColumn("Balance");
        rowdata = new Object[8];
        newaccount = false;

        JTable1 = new JTable(model);
        super.JTable1 = this.JTable1;

        super.JScrollPane1.getViewport().add(JTable1);

        JButton_PerAC.setText("Add Credit-Card Account");
        JPanel1.add(JButton_PerAC);
        JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_CompAC.setText("Generate Monthly Bills");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
    	JButton_CompAC.setBounds(240,20,192,33);

		//JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);

		refreshTable();

    }

    @Override
    protected void JButtonPerAC_actionPerformed(ActionEvent event) {
        JDialog_AddAcc pac = new AddCreditCardDialog(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        System.err.println("newaccout : " + newaccount);

        if (newaccount) {
            refreshTable();
            newaccount = false;
        }

    }

    @Override
    protected void JButtonCompAC_actionPerformed(ActionEvent event) {

        JDialog_AddAcc pac = new AddCreditCardDialog(myframe);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        System.err.println("newaccout : " + newaccount);

        if (newaccount) {
            refreshTable();
            newaccount = false;
        }



    }

    @Override
    protected void JButtonDeposit_actionPerformed(ActionEvent event) {
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
    protected void JButtonWithdraw_actionPerformed(ActionEvent event) {
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

    protected void refreshTable() {
        if(model != null) {
            model.setRowCount(0);
            AccountController auc = new AccountController(new CreditAccountService());
            List<AbstractAccount> accounts = auc.getAllAccounts();
            System.err.println(accounts.toString());
            for (AbstractAccount acc : accounts) {
                if (acc != null) {

                    //if (acc.getUser() != null) {

                        rowdata[0] = acc.getUser().getName();
                        rowdata[1] = acc.getAccountNbr();
                        //rowdata[2] = acc.;//TODO: exp date
                        rowdata[3] = acc.getAccTypes();
                        rowdata[4] = acc.getCurrentBalance();
                        model.addRow(rowdata);
                  //  }
                }
                JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            }
        }
    }

}
