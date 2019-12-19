package framework.factory;

import framework.AccountTypes;
import framework.account.AbstractAccount;
import framework.account.Account;
import framework.user.AbstractUser;

public class AccountFactory {

    protected AccountFactory(){}
    private static AccountFactory accountFactory;

    public static AccountFactory getInstance(){
        if (accountFactory==null) {
            return accountFactory = new AccountFactory();
        }
        return accountFactory;
    }


    public AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user){
        System.err.println("AccountFactory :: createAccount() Entered");
        if (accountTypes==AccountTypes.BASIC){
            //accountFactory = new AccountFactory();
           Account newAcc = new Account(accountNumber,user);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }
        return null;
    }
}
