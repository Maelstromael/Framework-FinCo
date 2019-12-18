package banking.factory;

import banking.account.SavingsAccount;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.user.AbstractUser;

public class SavingsAccountFactory extends AbstractAccountFactory {
    @Override
    public AbstractAccount createAccount(String accountNumber, AbstractUser user) {
        return new SavingsAccount(accountNumber, user);
    }
}
