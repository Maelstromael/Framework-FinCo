package framework.dao;

import framework.AccountTypes;
import framework.account.AbstractAccount;
import framework.entry.IEntry;

import javax.swing.*;
import java.util.*;

public class AccountDao implements IAccountDao {
    private HashMap<String,AbstractAccount> accountList = new HashMap<>();
    private static AccountDao accountDao=null;

    protected AccountDao(){}

    @Override
    public AbstractAccount save(AbstractAccount account) {
        System.err.println("AccountIdao :: save() Entered");
        if (account!=null){
            System.err.println("AccountIdao :: save() Entered: "+account.toString());
            //changes --
            String name = account.getAccountNbr();
            if(accountList.containsKey(name)) {
                accountList.replace(name, account);
            }else {
                accountList.put(name, account);
            }
            return account;
        }
        return null;
    }

    public static AccountDao getAccountDao() {
        if (accountDao==null){
            accountDao=new AccountDao();
        }
        return accountDao;
    }

    public HashMap<String, List<IEntry>> generateAccountStatements(){
        HashMap<String,List<IEntry>> statements = new HashMap<>();
        List<AbstractAccount> accounts = getAllAccounts();
        for (AbstractAccount account: accounts){
            statements.put(account.getUser().getName(), account.getEntries());
        }
        return statements;
    }

    //changes - private to public
    private List<AbstractAccount> getAllAccounts(){
        List<AbstractAccount> accounts = new ArrayList<>();
        Iterator<Map.Entry<String, AbstractAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()) {
            AbstractAccount account = iterator.next().getValue();
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public boolean delete(AbstractAccount account) {
        if(account!=null) {
            accountList.remove(account.getAccountNbr());
            return true;
        }
        return false;
    }


    @Override
    public AbstractAccount get(String id) {
        System.err.println("AccountIDao :: get() Entered name: "+id);
        return accountList.get(id);
    }

    @Override
    public AbstractAccount getByName(String name) {
        System.err.println("AccountIDao :: getbyName() Entered name: "+name);
        Iterator<Map.Entry<String, AbstractAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()){
            AbstractAccount account = iterator.next().getValue();
            System.err.println(account.toString());
            if (name.equals(account.getUser().getName())){
                return account;
            }
        }
        return null;
    }

    @Override
    public List<AbstractAccount> getAll() {
        System.err.println("AccountDao :: getAll() Entered");
        List<AbstractAccount> accounts = new ArrayList<>();
        Iterator<Map.Entry<String, AbstractAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()) {
            AbstractAccount account = iterator.next().getValue();
            accounts.add(account);
        }
        System.err.println("AccountDao :: getAll() exited : " + accounts.size());
        return accounts;
    }


}
