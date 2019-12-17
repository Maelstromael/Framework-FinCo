package framework.dao;

public interface IDao<T> {
    void save(T t);
    void delete(T t);
    T get(String id);
}
