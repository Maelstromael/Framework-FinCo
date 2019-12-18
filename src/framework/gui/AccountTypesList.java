package framework.gui;

import javax.swing.*;

public class AccountTypesList {

    private static AccountTypesList accountTypesList;
    private static ButtonGroup accountTypes = new ButtonGroup();

    private AccountTypesList(){}

    public static AccountTypesList getInstance(){
        if(accountTypesList == null){
            accountTypesList = new AccountTypesList();
        }else {
            accountTypes = new ButtonGroup();
        }
        return accountTypesList;
    }

    public void addChoice(JRadioButton radio){
        this.accountTypes.add(radio);
    }

}
