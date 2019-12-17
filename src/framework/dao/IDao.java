package framework.dao;

public interface IDao<T> {
    T save(T t);
    boolean delete(T t);
    T get(String id);
    T getByName(String name);
}
