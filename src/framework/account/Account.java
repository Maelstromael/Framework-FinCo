package framework.account;

import framework.entry.Entry;
import framework.user.AbstractUser;

import java.time.LocalDate;

public class Account extends AbstractAccount {
    private final double bound = 500d; //TODO
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




    @Override
    public boolean deposit(double amount) {
        boolean result = super.deposit(amount);
        if(result) this.notifyCustomer(amount , "Deposit");
        return result;
    }

    @Override
    public boolean withdraw(double amount) {
        boolean result = super.withdraw(amount);
        if(result) this.notifyCustomer(amount , "Withdraw");
        return result;
    }

    private String notifyCustomer(double amount, String type){
        //TODO
        String message = "Transaction of " + LocalDate.now() + " : " + type
                + System.lineSeparator() + "Amount : $" + amount;

        this.user.notify(message , amount, this.currentBalance , this.bound);

        return message;
    }
}
