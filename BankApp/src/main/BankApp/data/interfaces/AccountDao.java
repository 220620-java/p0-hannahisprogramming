package main.BankApp.data.interfaces;

import main.BankApp.models.Account;
import main.BankApp.models.User;

public interface AccountDao {
    Account create(Account account, String type, double balance, User user);
    Account getAccountInfo(User user);
    Account updateBalance(Account account, double balance, String transType, double amount);
}
