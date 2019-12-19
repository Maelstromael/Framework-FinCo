package framework.service;

import framework.account.AbstractAccount;
import framework.account.Account;
import framework.dao.AccountDao;
import framework.dao.IDao;
import framework.entry.IEntry;

import java.util.List;

public class AccountService implements IAccountService {
    private IDao<AbstractAccount> accountIDao = AccountDao.getAccountDao(); //singleton pattern

    @Override
    public boolean deposit(String name, double amount) {
        System.err.println("AccountService :: deposit() name: "+name);
        if (name!=null){
           AbstractAccount account = accountIDao.get(name);
            System.err.println("AccountService :: withdraw() Entered: accountIDao.get(name) ");
            if (account!=null){
                boolean res = account.deposit(amount);
                if(res){
                    accountIDao.save(account);
                    return res;
                }
            }

        }
       return false;
    }

    @Override
    public boolean withdraw(String name, double amount) {
        System.err.println("AccountService :: withdraw() Entered");
        if (name!=null){
            AbstractAccount account = accountIDao.get(name);
            if (account!=null) {
                System.err.println("AccountService :: withdraw() Entered: accountIDao.get(name) ");
                boolean res = account.withdraw(amount);
                if(res){
                    accountIDao.save(account);
                    return res;
                }

            }
        }
        return false;
    }

    @Override
    public double getBalance(String name) {
        System.err.println("AccountService :: getBalance() Entered");
        if (name!=null){
            AbstractAccount account = accountIDao.get(name);
            if (account!=null) {
                System.err.println("AccountService :: getBalance() Entered: accountIDao.get(name) ");
                return account.getCurrentBalance();
            }
        }
        return 0.0;
    }

    @Override
    public List<AbstractAccount> getAll() {
        System.err.println("AccountService :: getAll() Entered");
        return accountIDao.getAll();
    }
    @Override
    public void addInterest() {
        System.err.println("AccountService :: addInterest() ");
        for (AbstractAccount account: this.getAll()){
            account.addInterest();
            accountIDao.save(account);
        }
    }

    public List<IEntry> generateStatement(String name){
        return accountIDao.getByName(name).getEntries();
    }
}
