package main.BankApp.data;

import main.BankApp.models.Account;
import main.BankApp.models.User;

public interface AccountDao {
    Account create(Account account, User user, double balance);
    Account get(Account account, User user);
    Account updateBalance(Account account, double amount);
}
