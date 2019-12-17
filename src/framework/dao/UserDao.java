package framework.dao;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.util.HashMap;

public class UserDao implements IUserDao {
    private HashMap<String,AbstractUser> userList = new HashMap<>();
    @Override
    public void save(AbstractUser user) {
        if (user!=null)userList.put(user.getId(),user);
    }

    @Override
    public void delete(AbstractUser user) {
        if (user!=null) userList.remove(user.getId());
    }

    @Override
    public AbstractUser get(String id) {

        return userList.get(id);
    }
}
