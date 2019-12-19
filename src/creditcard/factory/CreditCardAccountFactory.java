package creditcard.factory;

import creditcard.account.BronzeCreditCardAccount;
import creditcard.account.GoldCreditCardAccount;
import creditcard.account.SilverCreditCardAccount;
import framework.AccountTypes;
import framework.account.AbstractAccount;
import framework.account.Account;
import framework.factory.AccountFactory;
import framework.user.AbstractUser;

public class CreditCardAccountFactory extends AccountFactory {

    private static CreditCardAccountFactory creditCardAccountFactory;

    private CreditCardAccountFactory(){
        super();
    }
   // private static String expDate;

    public static CreditCardAccountFactory getInstance(){
        if(creditCardAccountFactory == null){
            creditCardAccountFactory = new CreditCardAccountFactory();
        }

        return creditCardAccountFactory;
    }



    public Account createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user) {
        System.err.println("CreditCardAccountFactory :: createAccount() Entered");
        Account newAcc =null;
        if (accountTypes== AccountTypes.GOLD){
            newAcc = new GoldCreditCardAccount(accountNumber,user);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }else if(accountTypes== AccountTypes.SILVER){
            newAcc = new SilverCreditCardAccount(accountNumber,user);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }else if(accountTypes== AccountTypes.BRONZE){
            newAcc = new BronzeCreditCardAccount(accountNumber,user);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }
        return null;

    }

}
