package framework.controller;

import framework.account.AbstractAccount;
import framework.service.IAccountService;
import framework.user.AbstractUser;

import java.util.List;

public abstract class AbstractAccountController implements IAccountController{
    protected IAccountService accountService;

    public AbstractAccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    public abstract boolean deposit(String name, double amount);
    public abstract boolean withdraw(String name, double amount);
    public abstract double getBalance(String name);
    public abstract List<AbstractAccount> getAllAccounts();
    public abstract AbstractUser getUser(String name);
}
