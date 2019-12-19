package framework.service;

import framework.account.AbstractAccount;
import framework.account.Account;

import java.util.ArrayList;
import java.util.List;

public interface IAccountService<T> {
    boolean deposit(String name, double amount);
    boolean withdraw(String name, double amount);
    double getBalance(String name);
    void addInterest();
    List<T> getAll();
}
