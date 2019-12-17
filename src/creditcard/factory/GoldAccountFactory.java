package creditcard.factory;

import creditcard.account.GoldCreditCardAccount;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.user.AbstractUser;

public class GoldAccountFactory extends AbstractAccountFactory {

    @Override
    public AbstractAccount createAccount(String accountNumber, AbstractUser user) {
        return new GoldCreditCardAccount(accountNumber, user);
    }
}
