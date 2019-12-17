package framework.factory;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

public abstract class AbstractAccountFactory implements IFactory {
    public abstract AbstractAccount createAccount(String accountNumber, AbstractUser user);
}
