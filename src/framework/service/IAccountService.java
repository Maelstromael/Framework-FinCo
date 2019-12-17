package framework.service;

import framework.account.AbstractAccount;

import java.util.ArrayList;
import java.util.List;

public interface IAccountService extends IService {
    boolean deposit(String name, double amount);
    boolean withdraw(String name, double amount);
    double getBalance(String name);
    List<AbstractAccount> getAll();
}
