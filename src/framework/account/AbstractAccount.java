package framework.account;

import framework.entry.IEntry;
import framework.user.AbstractUser;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount implements IAccount{
    private String accNbr;
    protected double currentBalance =0.0;
    private AbstractUser user;

    private List<IEntry> entries = new ArrayList<>();

    public AbstractAccount(String accountNumber, double accountBalance, AbstractUser user) {
        this.accNbr = accountNumber;
        this.currentBalance = accountBalance;
        this.user=user;
    }

    public AbstractAccount(String accountNumber, AbstractUser user){
            this.accNbr=accountNumber;
            this.user=user;
            this.currentBalance=0.0;
        }

    /*public AbstractUser getUser() {
        return user;
    }*/

    public IEntry addEntry(IEntry entry){
        if (entry!=null) {
            entries.add(entry);
            return entry;
        }
        return null;
    }

    public String getAccountNbr() {
        return accNbr;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
