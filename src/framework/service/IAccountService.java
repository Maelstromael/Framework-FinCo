package framework.service;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.util.List;

public interface IAccountService extends IService {
    boolean deposit(String name, double amount);
    boolean withdraw(String name, double amount);
    double getBalance(String name);
    List<AbstractAccount> getAllAccounts();
    AbstractUser getUser(String name);
}
