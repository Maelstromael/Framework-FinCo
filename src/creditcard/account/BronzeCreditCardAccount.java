package creditcard.account;

import framework.user.AbstractUser;

public class BronzeCreditCardAccount extends AbstractCreditCardAccount {

    private final double X = 0.06;
    private final double Y = 0.14;

    public BronzeCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public BronzeCreditCardAccount(String accountNumber, AbstractUser user) {
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
