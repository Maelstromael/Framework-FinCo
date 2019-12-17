package creditcard.account;

import framework.user.AbstractUser;

public class GoldCreditCardAccount extends AbstractCreditCardAccount {

    private final double X = 0.05;
    private final double Y = 0.1;

    public GoldCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public GoldCreditCardAccount(String accountNumber, AbstractUser user) {
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
