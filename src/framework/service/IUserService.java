package framework.service;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.util.List;

public interface IUserService extends IService {
    AbstractUser createUser(UserType type,String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts);
    boolean removeAccount(String name);
    AbstractAccount addAccount(AbstractAccount account);
    AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user);
}
