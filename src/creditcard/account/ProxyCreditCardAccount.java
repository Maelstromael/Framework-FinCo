package creditcard.account;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

public class ProxyCreditCardAccount extends AbstractCreditCardAccount {
    public ProxyCreditCardAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public ProxyCreditCardAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    public ProxyCreditCardAccount(AbstractAccount account){
        super(account.getAccountNbr(),account.getUser());
        this.setAccTypes(account.getAccTypes());
        currentBalance = account.getCurrentBalance();

    }

    @Override
    public double getNewMonthlyBalance() {
        return 0;
    }

    @Override
    public double getMonthlyAmountDue() {
        return 0;
    }
}
