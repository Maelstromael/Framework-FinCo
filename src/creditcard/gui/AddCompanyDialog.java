package creditcard.gui;

import banking.factory.BankSimpleFactory;
import framework.AccountTypes;
import framework.UserType;
import framework.Utils;
import framework.account.AbstractAccount;
import framework.controller.UserController;
import framework.gui.JDialog_AddCompAcc;
import framework.service.UserService;
import framework.user.AbstractUser;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCompanyDialog extends JDialog_AddCompAcc {

    Ccard parentframe;
    //boolean newaccount = false;

    public AddCompanyDialog(Ccard parent) {
        super(parent);

        parentframe = parent;

        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setSelected(true);
		JRadioButton_Chk.setActionCommand("Checkings");
		super.choicePane.add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
        super.choicePane.add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36,36,84,24);

        typeChoiceGroup.add(JRadioButton_Chk);
        typeChoiceGroup.add(JRadioButton_Sav);

        super.getContentPane().repaint();
    }

    ButtonGroup typeChoiceGroup = new ButtonGroup();

    JRadioButton JRadioButton_Chk = new JRadioButton();
    JRadioButton JRadioButton_Sav = new JRadioButton();

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {

        JTextField[] fieldArr = {JTextField_ACNR,JTextField_NAME,JTextField_STR,JTextField_CT,JTextField_ZIP,JTextField_ST, JTextField_EM};
        ArrayList<JTextField> listFields = new ArrayList<>();
        listFields.addAll(Arrays.asList(fieldArr));
        //check if required fields is not missing
        if(Utils.requiredJTextFields(listFields)){
            UserController uc = new UserController(new UserService());
            AbstractUser user  = uc.createUser(UserType.COMPANY,JTextField_NAME.getText(), JTextField_STR.getText(), JTextField_CT.getText(), JTextField_ST.getText(), JTextField_EM.getText(), JTextField_ZIP.getText(), null);
            if(user != null){
                AccountTypes accountType;
                if (JRadioButton_Chk.isSelected()){
                    accountType= AccountTypes.CHECKINGS;
                }
                else {
                    accountType= AccountTypes.SAVINGS;
                }
                AbstractAccount acc = uc.createAccount(accountType,JTextField_ACNR.getText(),user, BankSimpleFactory.getInstance());
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
