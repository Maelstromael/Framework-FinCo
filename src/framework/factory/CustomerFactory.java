package framework.factory;

import framework.UserType;
import framework.account.AbstractAccount;
import framework.user.AbstractUser;
import framework.user.Company;
import framework.user.Person;

import java.util.List;

public class CustomerFactory {

    private CustomerFactory(){}
    private static CustomerFactory customerFactory;

    public static CustomerFactory getInstance(){
        if (customerFactory==null) {
            return customerFactory = new CustomerFactory();
        }
        return customerFactory;
    }

    public AbstractUser createUser(UserType userType, String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts){

        if (userType==UserType.COMPANY){
            AbstractUser newUser = new Company(name,street,city,state,email,zip,accounts);
            newUser.setUserType(userType);
            return newUser;
        }
        else if (userType==UserType.PERSON){
            AbstractUser newUser =  new Person(name,street,city,state,email,zip,accounts);
            newUser.setUserType(userType);
            return newUser;
        }
        return null;
    }

}
