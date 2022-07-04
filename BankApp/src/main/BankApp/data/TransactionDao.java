package main.BankApp.data;

import main.BankApp.models.Account;
import main.BankApp.models.Transaction;

import java.sql.Timestamp;

public interface TransactionDao {
    Transaction create(String transType, Timestamp transDate, double amount, Account account);
    Transaction get(String transType, Timestamp transDate, double amount, Account account);
}
