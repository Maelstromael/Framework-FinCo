package framework.factory;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

public abstract class AbstractAccountFactory {
    public abstract AbstractAccount createAccount(String accountNumber, AbstractUser user);
}
