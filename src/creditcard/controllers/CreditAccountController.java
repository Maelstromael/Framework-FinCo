package creditcard.controllers;

import creditcard.service.CreditAccountService;
import framework.controller.AccountController;
import framework.service.IAccountService;

public class CreditAccountController extends AccountController {
    CreditAccountService service;
    public CreditAccountController(CreditAccountService accountService) {
        super(accountService);
        service = accountService;
    }
}
