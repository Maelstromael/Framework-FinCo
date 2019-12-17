package framework.dao;

import framework.account.AbstractAccount;
import framework.user.AbstractUser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UserDao implements IUserDao {
    private HashMap<String,AbstractUser> userList = new HashMap<>();
    private int lastId = 1;
    @Override
    public AbstractUser save(AbstractUser user) {
        if (user!=null){
            if (user.getId()==null || user.getId().equals("")){
                user.setId(++lastId+"");
            }
            userList.put(user.getId(),user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(AbstractUser user) {
        if (user!=null){
            userList.remove(user.getId());
            return true;
        }
        return false;
    }

    @Override
    public AbstractUser get(String id) {
        return userList.get(id);
    }

    @Override
    public AbstractUser getByName(String name) {
        Iterator<Map.Entry<String, AbstractUser>> iterator = userList.entrySet().iterator();
        while (iterator.hasNext()){
            AbstractUser user = iterator.next().getValue();
            if (name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<AbstractUser> getAll() {
        return null;
    }
}
