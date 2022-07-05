package main.BankApp.data.interfaces;

import main.BankApp.dataStructure.List;
import main.BankApp.models.Account;
import main.BankApp.models.Transaction;

public interface TransDao {
    Transaction create(Transaction transaction, int id, String transType, double amount, Account account);
    List<Transaction> findByAccount(Account account);
}
