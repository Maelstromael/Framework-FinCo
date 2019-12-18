package framework.service;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.dao.AccountDao;
import framework.dao.IDao;
import framework.dao.UserDao;
import framework.factory.SimpleFactory;
import framework.user.AbstractUser;

import java.util.List;

public class UserService implements IUserService {
    private IDao<AbstractUser> userIDao = new UserDao();
    private IDao<AbstractAccount> accountIDao = AccountDao.getAccountDao();

    @Override
    public AbstractUser createUser(UserType type,String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        SimpleFactory simpleFactory = SimpleFactory.getInstance();
        return userIDao.save(simpleFactory.creatUser(type, name, street, city, state, email, zip, accounts));
    }

    @Override
    public boolean removeAccount(String name) {
        return accountIDao.delete(accountIDao.get(name));
    }

    @Override
    public AbstractAccount addAccount(AbstractAccount account) {
        return accountIDao.save(account);
    }

    @Override
    public AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user) {
        System.err.println("UserService :: createAccount() Entered");
        SimpleFactory simpleFactory = SimpleFactory.getInstance();
        return accountIDao.save(simpleFactory.createAccount(accountTypes, accountNumber, user));
    }
}
