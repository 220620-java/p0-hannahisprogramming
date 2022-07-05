package main.BankApp.data;

import main.BankApp.db.Connect;
import main.BankApp.models.Account;
import main.BankApp.models.User;

import java.sql.SQLException;

public class AccountSQL {
    private Connect connection = Connect.connectToDb();

    @Override
    public Account create(Account account, User user, double balance){
        try (connection){
            String sql = "insert into bank.accounts" + "(id, accountType, balance, userId)" + "values (default, ?, ?, ?)";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
