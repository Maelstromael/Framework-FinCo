package creditcard.gui;

import banking.factory.BankSimpleFactory;
import creditcard.factory.CreditCardSimpleFactory;
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
        radioBox.add(JRadioButton_Gold);
        //JRadioButton_Sil.setBounds(36,12,84,24);
        JRadioButton_Sil.setText("SILVER");
        JRadioButton_Sil.setActionCommand("SILVER");
        radioBox.add(JRadioButton_Sil);
        //JRadioButton_Sil.setBounds(36,36,84,24);
        JRadioButton_Bron.setText("BRONZE");
        JRadioButton_Bron.setActionCommand("BRONZE");
        radioBox.add(JRadioButton_Bron);

        typeChoiceGroup.add(JRadioButton_Gold);
        typeChoiceGroup.add(JRadioButton_Sil);
        typeChoiceGroup.add(JRadioButton_Bron);

        super.choicePane.add(radioBox);

        choicePane.setBounds(5,5,300,30);
        super.getContentPane().repaint();
    }

    ButtonGroup typeChoiceGroup = new ButtonGroup();

    JRadioButton JRadioButton_Gold = new JRadioButton();
    JRadioButton JRadioButton_Sil = new JRadioButton();
    JRadioButton JRadioButton_Bron = new JRadioButton();

    @Override
    protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {

        JTextField[] fieldArr = {JTextField_BD,JTextField_ACNR,JTextField_NAME,JTextField_STR,JTextField_CT,JTextField_ZIP,JTextField_ST, JTextField_EM};
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
                AbstractAccount acc = uc.createAccount(accountType,JTextField_ACNR.getText(),user, CreditCardSimpleFactory.getInstance());
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
