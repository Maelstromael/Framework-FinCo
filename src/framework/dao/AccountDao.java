package framework.dao;

import framework.account.AbstractAccount;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AccountDao implements IAccountDao {
    private HashMap<String,AbstractAccount> accountList = new HashMap<>();

    @Override
    public void save(AbstractAccount account) {
        if (account!=null)accountList.put(account.getAccountNbr(),account);
    }

  /*  public boolean deposit(String name, double amount){
        if (accountList.containsKey(name)){
            accountList.get(name).deposit(amount);
        }
    }*/

    @Override
    public void delete(AbstractAccount account) {
        if(account!=null) accountList.remove(account.getAccountNbr());
    }
/*
    public void printEntries(){
        Iterator<Map.Entry<String, AbstractAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()){
            AbstractAccount account = iterator.next().getValue();
            account.
        }
    }*/

    @Override
    public AbstractAccount get(String id) {
        return accountList.get(id);
    }


}
