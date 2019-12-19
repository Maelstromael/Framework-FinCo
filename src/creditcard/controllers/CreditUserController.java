package creditcard.controllers;

import creditcard.account.AbstractCreditCardAccount;
import creditcard.service.CreditUserService;
import framework.AccountTypes;
import framework.account.AbstractAccount;
import framework.controller.UserController;
import framework.factory.SimpleFactory;
import framework.service.IUserService;
import framework.service.UserService;
import framework.user.AbstractUser;

public class CreditUserController extends UserController {
    CreditUserService creditUserService;
    public CreditUserController(CreditUserService service) {
        super(service);
        creditUserService = service;

    }

    @Override
    public AbstractCreditCardAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user, SimpleFactory factory) {
        //return super.createAccount(accountTypes, accountNumber, user, factory);
        return creditUserService.createAccount(accountTypes, accountNumber, user, factory);
    }
}
