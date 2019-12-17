package banking.factory;

import banking.account.CheckingsAccount;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.user.AbstractUser;

public class CheckingAccountFactory extends AbstractAccountFactory {

    @Override
    public AbstractAccount createAccount(String accountNumber, AbstractUser user) {
        return new CheckingsAccount(accountNumber, user);
    }
}
