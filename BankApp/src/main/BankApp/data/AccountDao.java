package main.BankApp.data;

import main.BankApp.models.Account;
import main.BankApp.models.User;

public interface AccountDao {
    Account create(Account account, String type, double balance, User user);
    Account get(Account account, User user);
    Account updateBalance(Account account, double balance, double amount);
}
