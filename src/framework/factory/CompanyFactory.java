package framework.factory;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;
import framework.user.Company;

import java.util.List;

public class CompanyFactory extends AbstractUserFactory{
    @Override
    public AbstractUser createUser(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        return new Company(name,street,city,state,email,zip,accounts);
    }
}
