package framework.service;

import framework.account.AbstractAccount;
import framework.dao.AccountDao;
import framework.dao.IDao;
import framework.entry.IEntry;

import java.util.List;

public class AccountService implements IAccountService {
    private IDao<AbstractAccount> accountIDao = AccountDao.getAccountDao(); //singleton pattern

    @Override
    public boolean deposit(String name, double amount) {
        if (name!=null){
            AbstractAccount account = accountIDao.getByName(name);
            if (account!=null)
            return account.deposit(amount);
        }
       return false;
    }

    @Override
    public boolean withdraw(String name, double amount) {
        if (name!=null){
            AbstractAccount account = accountIDao.getByName(name);
            if (account!=null)
                return account.withdraw(amount);
        }
        return false;
    }

    @Override
    public double getBalance(String name) {
        return 0;
    }

    @Override
    public List<AbstractAccount> getAll() {
        return accountIDao.getAll();
    }

    public List<IEntry> generateStatement(String name){
        return accountIDao.getByName(name).getEntries();
    }
}
