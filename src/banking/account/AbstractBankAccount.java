package banking.account;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.time.LocalDate;

public abstract class AbstractBankAccount extends AbstractAccount {

    private final double bound = 500d; //TODO

    public AbstractBankAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public AbstractBankAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    public abstract void addInterest();

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
