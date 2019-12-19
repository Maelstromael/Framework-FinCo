package framework.controller;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.factory.SimpleFactory;
import framework.service.IUserService;
import framework.user.AbstractUser;

import java.util.List;

public class UserController extends AbstractUserController {
    public UserController(IUserService service) {
        super(service);
    }

    @Override
    public AbstractUser createUser(UserType type, String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        return service.createUser(type, name, street, city, state, email, zip, accounts);
    }

    @Override
    public boolean removeAccount(String name) {
        return service.removeAccount(name);
    }

    @Override
    public AbstractAccount addAccount(AbstractAccount account) {
        return service.addAccount(account);
    }

    @Override
    public AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user, SimpleFactory factory) {
        System.err.println("UserController :: createAccount() Entered");
        return service.createAccount(accountTypes, accountNumber, user, factory );
    }
}
