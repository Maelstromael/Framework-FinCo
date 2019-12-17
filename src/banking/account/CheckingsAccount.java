package banking.account;

import framework.user.AbstractUser;

public class CheckingsAccount extends AbstractBankAccount {
    private final double interest_rate = 0.01;

    public CheckingsAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public CheckingsAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    @Override
    public void addInterest() {
        this.currentBalance += this.currentBalance * this.interest_rate;
    }
}
