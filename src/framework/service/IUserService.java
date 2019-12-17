package framework.service;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.util.List;

public interface IUserService extends IService {
    AbstractUser createUser(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts);
    boolean removeAccount(String name);
    AbstractAccount addAccount(AbstractAccount account);
}
