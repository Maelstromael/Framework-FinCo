package creditcard.factory;

import creditcard.account.BronzeCreditCardAccount;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.user.AbstractUser;

public class BronzeAccountFactory extends AbstractAccountFactory {
    @Override
    public AbstractAccount createAccount(String accountNumber, AbstractUser user) {
        return new BronzeCreditCardAccount(accountNumber, user);
    }
}
