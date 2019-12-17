package creditcard.account;

import framework.user.AbstractUser;

public class SilverCreditCardAccount extends AbstractCreditCardAccount {

    private final double X = 0.055;
    private final double Y = 0.12;

    public SilverCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public SilverCreditCardAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    @Override
    public double getNewMonthlyBalance() {
        //TODO
        return 0;
    }

    @Override
    public double getMonthlyAmountDue() {
        //TODO
        return 0;
    }
}
