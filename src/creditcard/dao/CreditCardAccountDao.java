package creditcard.dao;

import creditcard.account.AbstractCreditCardAccount;
import framework.account.AbstractAccount;
import framework.dao.AccountDao;
import framework.entry.IEntry;

import java.util.*;

public class CreditCardAccountDao extends AccountDao {
    private HashMap<String, AbstractCreditCardAccount> accountList = new HashMap<>();
    private static CreditCardAccountDao accountDao=null;
    private CreditCardAccountDao(){
        super();
    }

    public static CreditCardAccountDao getAccountDao() {
        if (accountDao==null){
            accountDao=new CreditCardAccountDao();
        }
        return accountDao;
    }


    public AbstractAccount save(AbstractCreditCardAccount account) {
        System.err.println("AccountIdao :: save() Entered");
        if (account!=null){
            System.err.println("AccountIdao :: save() Entered: "+account.toString());
            //changes --
            String name = account.getAccountNbr();
            String accN;
            String expDate;
            if(name.contains("@@")){

            }
            if(accountList.containsKey(name)) {
                accountList.replace(name, account);
            }else {
                accountList.put(name, account);
            }
            return account;
        }
        return null;
    }

    public HashMap<String, List<IEntry>> generateAccountStatements(){
        HashMap<String,List<IEntry>> statements = new HashMap<>();
        List<AbstractCreditCardAccount> accounts = getAllAccounts();
        for (AbstractAccount account: accounts){
            statements.put(account.getUser().getName(), account.getEntries());
        }
        return statements;
    }

    //changes - private to public
    private List<AbstractCreditCardAccount> getAllAccounts(){
        List<AbstractCreditCardAccount> accounts = new ArrayList<>();
        Iterator<Map.Entry<String, AbstractCreditCardAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()) {
            AbstractCreditCardAccount account = iterator.next().getValue();
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
    public AbstractCreditCardAccount get(String id) {
        System.err.println("AccountIDao :: get() Entered name: "+id);
        return accountList.get(id);
    }

    @Override
    public AbstractCreditCardAccount getByName(String name) {
        System.err.println("AccountIDao :: getbyName() Entered name: "+name);
        Iterator<Map.Entry<String, AbstractCreditCardAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()){
            AbstractCreditCardAccount account = iterator.next().getValue();
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
        Iterator<Map.Entry<String, AbstractCreditCardAccount>> iterator = accountList.entrySet().iterator();
        while (iterator.hasNext()) {
            AbstractAccount account = iterator.next().getValue();
            accounts.add(account);
        }
        System.err.println("AccountDao :: getAll() exited : " + accounts.size());
        return accounts;
    }

}
