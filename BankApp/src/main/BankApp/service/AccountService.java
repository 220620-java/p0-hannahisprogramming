package main.BankApp.service;

import main.BankApp.data.interfaces.AccountDao;
import main.BankApp.data.methods.AccountSQL;
import main.BankApp.models.Account;
import main.BankApp.models.User;

public class AccountService {
    private AccountDao accountDao;
    public AccountService() { accountDao = new AccountSQL(); }


    public Account createAccount(Account account, String type, double balance, User user) {
        accountDao.create(account, type, balance, user);
        return account;
    }

    public Account getAccount(User user) {
        Account account = new Account();
        account = accountDao.getAccountInfo(user);
        return account;
    }

    public Account updateBalance(Account account, double balance, String transType, double amount) {
        accountDao.updateBalance(account, balance, transType, amount);
        return account;
    }
}
