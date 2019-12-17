package framework.account;

import framework.entry.Entry;
import framework.user.AbstractUser;

import java.time.LocalDate;

public class Account extends AbstractAccount {
    public Account(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }


    public Account(String accountNumber, AbstractUser user){
        super(accountNumber,0.0,user);
    }

    /*public boolean deposit(double amount){
        if (amount>0){
            this.currentBalance+=amount;
            Entry entry = new Entry(amount,LocalDate.now());
            this.addEntry(entry);
            return true;
        }
        return false;
    }*/
}
