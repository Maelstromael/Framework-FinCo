package creditcard.factory;

import creditcard.account.SilverCreditCardAccount;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.user.AbstractUser;

public class SilverAccountFactory extends AbstractAccountFactory {
    @Override
    public AbstractAccount createAccount(String accountNumber, AbstractUser user) {
        return new SilverCreditCardAccount(accountNumber, user);
    }
}
