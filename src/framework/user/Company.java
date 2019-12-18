package framework.user;

import framework.account.AbstractAccount;

import java.util.List;

public class Company extends AbstractUser implements ICompany {
    private int numberOfEmployees;
    public Company(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> account) {
        super(name, street, city, state, email, zip, account);
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public void addAccount(AbstractAccount account) {
        if (account!=null)this.accounts.add(account);
    }

    //refactor to the abstract class
    @Override
    public void removeAccount(AbstractAccount account) {
        if (this.accounts.contains(account))this.accounts.remove(account);
    }


    @Override
    public void sendEmail() {

    }
}
