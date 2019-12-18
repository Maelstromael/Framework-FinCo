package framework.controller;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.factory.SimpleFactory;
import framework.service.IUserService;
import framework.user.AbstractUser;

import java.util.List;

public abstract class AbstractUserController implements IUserController {
    protected IUserService service;

    public AbstractUserController(IUserService service){
        this.service=service;
    }

    public abstract AbstractUser createUser(UserType type, String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts);

    public abstract boolean removeAccount(String name);

    public abstract AbstractAccount addAccount(AbstractAccount account);

    public abstract AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user, SimpleFactory factory);
}
