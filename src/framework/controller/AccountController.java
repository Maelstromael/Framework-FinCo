package framework.controller;

import framework.account.AbstractAccount;
import framework.service.IAccountService;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AbstractAccount> getAllAccounts() {
        return accountService.getAll();
    }
}
