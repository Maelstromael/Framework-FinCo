package banking.factory;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.factory.SimpleFactory;
import framework.user.AbstractUser;

import java.util.List;

public class BankSimpleFactory extends SimpleFactory {

    private static BankSimpleFactory bankSimpleFactory;

    private BankSimpleFactory(){}

    public static BankSimpleFactory getInstance(){
        if(bankSimpleFactory == null){
            bankSimpleFactory = new BankSimpleFactory();
        }
        return bankSimpleFactory;
    }

    @Override
    public AbstractUser createUser(UserType userType, String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        return super.createUser(userType, name, street, city, state, email, zip, accounts);
    }

    public AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user) {
        AbstractAccountFactory accountFactory=null;
        if (accountTypes== AccountTypes.SAVINGS){
            accountFactory = new SavingsAccountFactory();
            return accountFactory.createAccount(accountNumber,user);
        }else if(accountTypes== AccountTypes.CHECKINGS){
            accountFactory = new CheckingAccountFactory();
            return accountFactory.createAccount(accountNumber,user);
        }
        return null;
    }
}
