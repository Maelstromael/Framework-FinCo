package creditcard.service;

import creditcard.account.AbstractCreditCardAccount;
import creditcard.dao.CreditCardAccountDao;
import framework.AccountTypes;
import framework.account.AbstractAccount;
import framework.dao.AccountDao;
import framework.dao.IDao;
import framework.dao.UserDao;
import framework.factory.SimpleFactory;
import framework.service.UserService;
import framework.user.AbstractUser;

public class CreditUserService extends UserService {
    private IDao<AbstractUser> userIDao = new UserDao();
    private CreditCardAccountDao accountIDao = CreditCardAccountDao.getAccountDao();

    @Override
    public AbstractCreditCardAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user, SimpleFactory factory) {
        System.err.println("CreditUserService :: createAccount() Entered");
        //SimpleFactory simpleFactory = SimpleFactory.getInstance();
        return (AbstractCreditCardAccount) accountIDao.save(factory.createAccount(accountTypes, accountNumber, user));
    }
}
