package framework.user;

import framework.account.AbstractAccount;

import java.util.List;

public abstract class AbstractUser implements IUser{
    private String id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String email;
    private String zip;
    protected List<AbstractAccount> accounts;

    public AbstractUser(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zip = zip;
        this.accounts = accounts;
    }

    public AbstractUser(String id,String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zip = zip;
        this.accounts = accounts;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void addAccount(AbstractAccount account);
    public abstract void removeAccount(AbstractAccount account);

    //TODO
    public abstract void sendEmail(String message);
    public abstract String notify(String message, double amount, double balance, double bound);

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public String getZip() {
        return zip;
    }

    /*public AbstractAccount getAccount() {
        return account;
    }*/
}
