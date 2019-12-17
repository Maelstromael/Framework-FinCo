package framework.service;

import framework.account.AbstractAccount;
import framework.dao.AccountDao;
import framework.dao.IDao;

public class AccountService implements IAccountService {
    private IDao<AbstractAccount> accountIDao = new AccountDao();

    @Override
    public boolean deposit(String name, double amount) {
        return false;
    }

    @Override
    public boolean withdraw(String name, double amount) {
        return false;
    }

    @Override
    public double getBalance(String name) {
        return 0;
    }
}
