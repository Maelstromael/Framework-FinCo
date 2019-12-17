package framework.controller;

import framework.service.IAccountService;

public abstract class AbstractAccountController implements IAccountController{
    protected IAccountService accountService;

    public AbstractAccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    public abstract boolean deposit(String name, double amount);
    public abstract boolean withdraw(String name, double amount);
    public abstract double getBalance(String name);
}
