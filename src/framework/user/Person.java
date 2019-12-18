package framework.user;

import framework.account.AbstractAccount;

import java.time.LocalDate;
import java.util.List;

public class Person extends AbstractUser implements IPerson {
    private LocalDate birthDate;
    public Person(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        super(name, street, city, state, email, zip, accounts);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public void addAccount(AbstractAccount account) {
        if (account!=null)
        this.accounts.add(account);
    }

    @Override
    public void removeAccount(AbstractAccount account) {
        if (this.accounts.contains(account))accounts.remove(account);
    }

    @Override
    public void sendEmail() {

    }
}
