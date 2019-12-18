package banking.account;

import framework.user.AbstractUser;

public class SavingsAccount extends AbstractBankAccount {
    private final double interest_rate = 0.0325;

    public SavingsAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public SavingsAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    @Override
    public void addInterest() {
        this.currentBalance += this.currentBalance * this.interest_rate;
    }
}
