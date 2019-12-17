package framework.factory;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.util.List;

public abstract class AbstractUserFactory implements IFactory {
  public abstract AbstractUser createUser(String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts);
}
