package main.BankApp.data;

import main.BankApp.utils.ConnectUtil;
import main.BankApp.models.Account;
import main.BankApp.models.User;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountSQL implements AccountDao {
    private ConnectUtil connUtil = ConnectUtil.getConnectUtil();

    @Override
    public Account create(Account account, User user, double balance){
        try (Connection conn = connUtil.getConnection()){
            String sql = "insert into bank.accounts" + "(id, accountType, balance, userId)" + "values (default, ?, ?, ?)";
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account get(Account account, User user){
        //www
    }

    @Override
    public Account updateBalance(Account account, double amount) {

    }
}
