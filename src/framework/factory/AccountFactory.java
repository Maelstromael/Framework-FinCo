package framework.factory;

import framework.account.AbstractAccount;
import framework.account.Account;
import framework.user.AbstractUser;

public class AccountFactory extends AbstractAccountFactory {
    @Override
    public AbstractAccount createAccount(String accountNumber, AbstractUser user) {
        return new Account(accountNumber,user);
    }
}
