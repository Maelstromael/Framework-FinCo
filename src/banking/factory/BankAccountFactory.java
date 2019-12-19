package banking.factory;

import banking.account.CheckingsAccount;
import banking.account.SavingsAccount;
import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.account.Account;
import framework.factory.AccountFactory;
import framework.factory.CustomerFactory;
import framework.user.AbstractUser;

import java.util.List;

public class BankAccountFactory extends AccountFactory {

    private static BankAccountFactory bankAccountFactory;

    private BankAccountFactory(){
        super();
    }

    public static BankAccountFactory getInstance(){
        if(bankAccountFactory == null){
            bankAccountFactory = new BankAccountFactory();
        }
        return bankAccountFactory;
    }


    public Account createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user) {
        System.err.println("BankAccountFactory :: createAccount() Entered");
        Account newAcc = null;
        if (accountTypes== AccountTypes.SAVINGS){
            newAcc = new SavingsAccount(accountNumber, user);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }else if(accountTypes== AccountTypes.CHECKINGS){
            newAcc = new CheckingsAccount(accountNumber, user);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }
        return newAcc;
    }
}
