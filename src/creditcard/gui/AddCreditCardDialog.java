package creditcard.gui;


import creditcard.factory.CreditCardAccountFactory;
import framework.AccountTypes;
import framework.UserType;
import framework.Utils;
import framework.account.AbstractAccount;
import framework.controller.UserController;
import framework.gui.JDialog_AddAcc;
import framework.service.UserService;
import framework.user.AbstractUser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCreditCardDialog extends JDialog_AddAcc {

    Ccard parentframe;

    public AddCreditCardDialog(Ccard parent) {
        super(parent);

        parentframe = parent;

        super.choicePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        Box radioBox = Box.createHorizontalBox();
        JRadioButton_Gold.setText("GOLD");
        JRadioButton_Gold.setSelected(true);
        JRadioButton_Gold.setActionCommand("GOLD");
        super.choicePane.add(JRadioButton_Gold);
        //JRadioButton_Sil.setBounds(36,12,84,24);
        JRadioButton_Sil.setText("SILVER");
        JRadioButton_Sil.setActionCommand("SILVER");
        super.choicePane.add(JRadioButton_Sil);
        //JRadioButton_Sil.setBounds(36,36,84,24);
        JRadioButton_Bron.setText("BRONZE");
        JRadioButton_Bron.setActionCommand("BRONZE");
        super.choicePane.add(JRadioButton_Bron);

        typeChoiceGroup.add(JRadioButton_Gold);
        typeChoiceGroup.add(JRadioButton_Sil);
        typeChoiceGroup.add(JRadioButton_Bron);

        JTextField_ACNR.setVisible(false);
        JLabel8.setVisible(false);

        JTextField_BD.setVisible(false);
        JLabel6.setVisible(false);

        JLabel7.setBounds(12,204,96,24);
        JTextField_EM.setBounds(84,204,156,20);

        super.choicePane.setBounds(5,5,100,90);

        JLabel10.setText("CC Number");
        JLabel10.setBounds(12,228,96,24);
        JLabel10.setForeground(java.awt.Color.black);
        super.getContentPane().add(JLabel10);

        JLabel11.setText("Exp Date");
        JLabel11.setBounds(12,252,96,24);
        JLabel11.setForeground(java.awt.Color.black);
        super.getContentPane().add(JLabel11);

        JTextField_CC.setBounds(84,228,156,20);
        super.getContentPane().add(JTextField_CC);

        JTextField_EXP.setBounds(84,252,156,20);
        super.getContentPane().add(JTextField_EXP);

        JButton_OK.setBounds(48,284,84,24);
        JButton_Cancel.setBounds(156,284,84,24);

        super.getContentPane().setSize(290,450);
        super.getContentPane().repaint();
    }

    ButtonGroup typeChoiceGroup = new ButtonGroup();

    JRadioButton JRadioButton_Gold = new JRadioButton();
    JRadioButton JRadioButton_Sil = new JRadioButton();
    JRadioButton JRadioButton_Bron = new JRadioButton();

    protected JLabel JLabel10 = new javax.swing.JLabel();
    protected JLabel JLabel11 = new javax.swing.JLabel();
    protected JTextField JTextField_CC = new javax.swing.JTextField();
    protected JTextField JTextField_EXP = new javax.swing.JTextField();

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {

        JTextField[] fieldArr = {JTextField_EXP,JTextField_CC,JTextField_NAME,JTextField_STR,JTextField_CT,JTextField_ZIP,JTextField_ST, JTextField_EM};
        ArrayList<JTextField> listFields = new ArrayList<>();
        listFields.addAll(Arrays.asList(fieldArr));
        //check if required fields is not missing
        if(Utils.requiredJTextFields(listFields)){
            UserController uc = new UserController(new UserService());
            AbstractUser user  = uc.createUser(UserType.PERSON,JTextField_NAME.getText(), JTextField_STR.getText(), JTextField_CT.getText(), JTextField_ST.getText(), JTextField_EM.getText(), JTextField_ZIP.getText(), null);
            if(user != null){
                AccountTypes accountType;
                if (JRadioButton_Gold.isSelected()){
                    accountType= AccountTypes.GOLD;
                }
                else if (JRadioButton_Sil.isSelected()){
                    accountType= AccountTypes.SILVER;
                }
                else {
                    accountType= AccountTypes.BRONZE;
                }
                AbstractAccount acc = uc.createAccount(accountType,JTextField_CC.getText(),user, CreditCardAccountFactory.getInstance());
                if(acc != null) {
                    Utils.showJoptMessage(parentframe, "Account Creation Successful");
                    parentframe.newaccount=true;
                } else {
                    Utils.showJoptMessage(parentframe, "Ooops.... Account Creation Failed");
                    return;
                }
            }
            else {
                Utils.showJoptMessage(parentframe, "Ooops.... User Creation Failed");
            }

        }
        else {
            Utils.showJoptMessage(parentframe, "Missing Field(s)!!!");
            return;
        }
        dispose();

    }

}
