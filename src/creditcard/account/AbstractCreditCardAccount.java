package creditcard.account;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.time.LocalDate;

public abstract class AbstractCreditCardAccount extends AbstractAccount {

    private LocalDate expDate;
    private double lastMonthBalance;
    private final double bound = 400d;

    public AbstractCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public AbstractCreditCardAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
        //this.expDate = LocalDate.parse(expDate);
        this.expDate = LocalDate.now().plusYears(3);
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

    public String generateMonthlyBillingReport(){
        //TODO: I added this
        double previous = this.getLastMonthBalance();
        double charges = this.getTotalMonthlyCharges();
        double credits = this.getTotalMonthlyCredits();

        String report =
                "Last month balance :       $" + previous + System.lineSeparator()
              + "Total charges this month : $" + charges + System.lineSeparator()
              + "Total credits this month : $" + credits + System.lineSeparator();

        return report;
    }

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
