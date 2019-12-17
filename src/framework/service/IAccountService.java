package framework.service;

public interface IAccountService extends IService {
    boolean deposit(String name, double amount);
    boolean withdraw(String name, double amount);
    double getBalance(String name);
}
