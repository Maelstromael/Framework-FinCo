package framework.factory;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;
import framework.user.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonFactory extends AbstractUserFactory {
    @Override
    public AbstractUser createUser(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        return new Person(name, street, city, state, email, zip, accounts);
    }
}
