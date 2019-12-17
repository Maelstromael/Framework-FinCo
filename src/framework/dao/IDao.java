package framework.dao;

import java.util.List;

public interface IDao<T> {
    T save(T t);
    boolean delete(T t);
    T get(String id);
    T getByName(String name);
    List<T> getAllAccounts();
    double getAccountBalance(String name);
}
