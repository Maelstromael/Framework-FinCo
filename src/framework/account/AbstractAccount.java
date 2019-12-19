package framework.account;

import framework.AccountTypes;
import framework.entry.Entry;
import framework.entry.IEntry;
import framework.user.AbstractUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccount implements IAccount{
    private String accNbr;
    protected double currentBalance = 0.0;
    protected AbstractUser user;
    //changes --
    private AccountTypes accTypes;
    protected double interest = 1;

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

    public AbstractUser getUser() {
        return user;
    }

    public boolean deposit(double amount){ //TODO: I encapsulated the "LocalDate.now()" inside a variable
        if (amount>0){
            currentBalance+=amount;
            LocalDate date = LocalDate.now();
            Entry entry = new Entry(amount,date );
            this.addEntry(entry);
            //TODO: update db balance of account

            //TODO: call notify
            return true;
        }
        else {
            return false;
        }
    }

    public boolean withdraw(double amount){ //TODO: I encapsulated the "LocalDate.now()" inside a variable
        if (amount<=currentBalance){
            currentBalance-=amount;
            LocalDate date = LocalDate.now();
            Entry entry = new Entry(-amount,date);
            this.addEntry(entry);

            //TODO: update db balance of account

            //TODO: call notify
            return true;
        }
        return false;
    }

    public List<IEntry> getEntries(){
        return entries;
    }



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

    @Override
    public String toString() {
        return "AbstractAccount{" +
                "accNbr='" + accNbr + '\'' +
                ", currentBalance=" + currentBalance +
                ", user=" + user +
                '}';
    }

    // changes --
    public AccountTypes getAccTypes() {
        return accTypes;
    }

    public void setAccTypes(AccountTypes accTypes) {
        this.accTypes = accTypes;
    }

    public double getInterest() {
        return interest;
    }
    public void addInterest(){
        currentBalance = currentBalance*getInterest();
    }
}
