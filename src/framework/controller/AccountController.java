package framework.controller;

import framework.service.IAccountService;

public class AccountController extends AbstractAccountController {
    public AccountController(IAccountService accountService) {
        super(accountService);
    }

    @Override
    public boolean deposit(String name, double amount) {
        return accountService.deposit(name,amount);
    }

    @Override
    public boolean withdraw(String name, double amount) {
        return accountService.withdraw(name,amount);
    }

    @Override
    public double getBalance(String name) {
        return accountService.getBalance(name);
    }
}
