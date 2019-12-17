package framework.factory;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.account.IAccount;
import framework.user.AbstractUser;
import framework.user.IUser;

import java.util.List;

public class SimpleFactory {
    private SimpleFactory(){}
    private static SimpleFactory simpleFactory;

    public static SimpleFactory getInstance(){
        if (simpleFactory==null) {
            return simpleFactory = new SimpleFactory();
        }
        return simpleFactory;
    }

    public AbstractUser creatUser(UserType userType,String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts){
        AbstractUserFactory iFactory = null;
        if (userType==UserType.COMPANY){
            System.out.println("company factory");
            iFactory = new CompanyFactory();
            AbstractUser newUser = iFactory.createUser(name,street,city,state,email,zip,accounts);
            newUser.setUserType(userType);
            System.out.println("user created and returned");
            return newUser;
        }
        else if (userType==UserType.PERSON){
            iFactory = new PersonFactory();
            AbstractUser newUser =  iFactory.createUser(name,street,city,state,email,zip,accounts);
            newUser.setUserType(userType);
            return newUser;
        }
        return null;
    }

    public AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user){
        AbstractAccountFactory accountFactory=null;
        if (accountTypes==AccountTypes.BASIC){
            System.out.println("account passed");
            accountFactory = new AccountFactory();
            AbstractAccount newAcc = accountFactory.createAccount(accountNumber,user);
            System.out.println("account saved " + newAcc);
            newAcc.setAccTypes(accountTypes);
            return newAcc;
        }
        return null;
    }
}
