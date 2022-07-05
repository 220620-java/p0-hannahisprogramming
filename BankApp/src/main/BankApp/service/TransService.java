package main.BankApp.service;

import main.BankApp.data.interfaces.TransDao;
import main.BankApp.data.methods.TransSQL;
import main.BankApp.dataStructure.List;
import main.BankApp.models.Account;
import main.BankApp.models.Transaction;

public class TransService {
    private TransDao transDao;
    public TransService() { transDao = new TransSQL(); }

    public Transaction createTrans(Transaction transaction, int id, String transType, double amount, Account account){
        return transDao.create(transaction, id, transType, amount, account);
    }

    public List<Transaction> findTransactions(Account account){
        return transDao.findByAccount(account);
    }
}
