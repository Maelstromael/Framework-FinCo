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
        System.err.println("AccountController :: deposit() Entered");
        return accountService.deposit(name,amount);
    }

    @Override
    public boolean withdraw(String name, double amount) {
        System.err.println("AccountController :: withdraw() Entered");
        return accountService.withdraw(name,amount);
    }

    @Override
    public double getBalance(String name) {
        return accountService.getBalance(name);
    }

    @Override
    public void addInterest() {
        accountService.addInterest();
    }

    @Override
    public List<AbstractAccount> getAllAccounts() {
        return accountService.getAll();
    }
}
