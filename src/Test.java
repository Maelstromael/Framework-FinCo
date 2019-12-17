import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.account.Account;
import framework.controller.AbstractAccountController;
import framework.controller.AbstractUserController;
import framework.controller.AccountController;
import framework.controller.UserController;
import framework.service.AccountService;
import framework.service.IUserService;
import framework.service.UserService;
import framework.user.AbstractUser;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        IUserService service = new UserService();
        AbstractUserController userController = new UserController(service);
        List<AbstractAccount> accounts=null;
        AbstractUser user1 = userController.createUser(UserType.PERSON,"Gilbert Ssebadduka","fairfield","Iowa","@gmail.com","dkfjkf","121234",accounts);
        userController.createAccount(AccountTypes.BASIC,"1234",user1);
        AbstractUser user2=userController.createUser(UserType.PERSON,"Steven Ssebadduka","fairfield","Iowa","@gmail.com","dkfjkf","121234",accounts);
        userController.createAccount(AccountTypes.BASIC,"1234",user2);
        AbstractUser user3=userController.createUser(UserType.COMPANY,"Company and advocates","fairfield","Iowa","@gmail.com","dkfjkf","121234",accounts);
        userController.createAccount(AccountTypes.BASIC,"1234",user3);

        AbstractUserController userController1 = new UserController(service);
        AbstractUser user4 = userController1.createUser(UserType.PERSON,"Gilbert Ssebadduka","fairfield","Iowa","@gmail.com","dkfjkf","121234",accounts);
        userController1.createAccount(AccountTypes.BASIC,"1234898989",user4);

        AccountController accountController = new AccountController(new AccountService());
        System.out.println("number of accounts " + accountController.getAllAccounts().size());
        System.out.println("=============================");
        System.out.println("number of accounts " + accountController.getAllAccounts());
        //System.out.println(accountController.getBalance(""));
        accountController.deposit("Gilbert Ssebadduka",233.8);
        System.out.println(accountController.getBalance("Gilbert Ssebadduka"));
        //System.out.println(accountController.getBalance(""));
    }
}
