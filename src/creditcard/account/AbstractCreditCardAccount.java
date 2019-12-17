package creditcard.account;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.time.LocalDate;

public abstract class AbstractCreditCardAccount extends AbstractAccount {

    private LocalDate expDate;
    private double lastMonthBalance;

    public AbstractCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public AbstractCreditCardAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public double getLastMonthBalance() {
        return lastMonthBalance;
    }

    public void setLastMonthBalance(double lastMonthBalance) {
        this.lastMonthBalance = lastMonthBalance;
    }

    public double getTotalMonthlyCredits(){
        //TODO
        return 0;
    }

    public double getTotalMonthlyCharges(){
        //TODO
        return 0;
    }

    public abstract double getNewMonthlyBalance();

    public abstract double getMonthlyAmountDue();

    public void notifyCardHolder(){
        //TODO
    }

}
