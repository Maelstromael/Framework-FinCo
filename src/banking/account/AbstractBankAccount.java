package banking.account;

import com.sun.xml.internal.bind.v2.TODO;
import framework.account.AbstractAccount;
import framework.user.AbstractUser;

public abstract class AbstractBankAccount extends AbstractAccount {
    public AbstractBankAccount(String accountNumber, double accountBalance, AbstractUser user) {
        super(accountNumber, accountBalance, user);
    }

    public AbstractBankAccount(String accountNumber, AbstractUser user) {
        super(accountNumber, user);
    }

    public abstract void addInterest();

    public void notifyCustomer(){
        //TODO
    }

}
