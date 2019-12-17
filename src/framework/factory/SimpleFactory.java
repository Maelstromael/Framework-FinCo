package framework.factory;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.account.IAccount;
import framework.user.AbstractUser;
import framework.user.IUser;

import java.util.List;

public class SimpleFactory {
    protected SimpleFactory(){}
    private static SimpleFactory simpleFactory;

    public static SimpleFactory getInstance(){
        if (simpleFactory==null) {
            return simpleFactory = new SimpleFactory();
        }
        return simpleFactory;
    }

    public AbstractUser createUser(Enum userType, String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts){
        AbstractUserFactory iFactory = null;
        if (userType==UserType.COMPANY){
            iFactory = new CompanyFactory();
            return iFactory.createUser(name,street,city,state,email,zip,accounts);
        }
        else if (userType==UserType.PERSON){
            iFactory = new PersonFactory();
            return iFactory.createUser(name,street,city,state,email,zip,accounts);
        }
        return null;
    }

    public AbstractAccount createAccount(Enum accountTypes, String accountNumber, AbstractUser user){
        AbstractAccountFactory accountFactory=null;
        if (accountTypes==AccountTypes.BASIC){
            accountFactory = new AccountFactory();
            return accountFactory.createAccount(accountNumber,user);
        }
        return null;
    }
}
