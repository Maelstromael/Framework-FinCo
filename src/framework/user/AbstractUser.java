package framework.user;

import framework.UserType;
import framework.account.AbstractAccount;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractUser implements IUser{
    private String id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String email;
    private String zip;
    private UserType userType;
    protected List<AbstractAccount> accounts = new ArrayList<>();

    public AbstractUser(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zip = zip;
    }

    public AbstractUser(String id,String name, String street, String city, String state, String email, String zip) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zip = zip;
        this.id=id;
    }

    public AbstractAccount getAccount(String accountNumber){
        for (AbstractAccount account: accounts){
            if (account.getAccountNbr().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void addAccount(AbstractAccount account);
    public abstract void removeAccount(AbstractAccount account);
    public abstract void sendEmail();

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

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

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
/*public AbstractAccount getAccount() {
        return account;
    }*/
}
