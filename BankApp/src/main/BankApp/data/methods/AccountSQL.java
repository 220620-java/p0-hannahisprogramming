package main.BankApp.data.methods;

import main.BankApp.data.interfaces.AccountDao;
import main.BankApp.utils.ConnectUtil;
import main.BankApp.models.Account;
import main.BankApp.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountSQL implements AccountDao {
    private final ConnectUtil connUtil = ConnectUtil.getConnectUtil();

    @Override
    public Account create(Account account, String type, double balance, User user){
        try (Connection conn = ConnectUtil.getConnection()){
            conn.setAutoCommit(false);

            String sql = "insert into accounts" + "(id, account_type, balance, user_id)" + "values (default, ?, ?, ?)";
            String[] keys = {"id"};

            PreparedStatement statement = conn.prepareStatement(sql, keys);
            statement.setString(1, type);
            statement.setDouble(2, balance);
            statement.setInt(3, user.getId());

            int rowsAffected = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next() && rowsAffected == 1) {
                account.setId(resultSet.getInt("id"));
                account.setAccountType(type);
                account.setBalance(balance);
                conn.commit();
            } else {
                conn.rollback();
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account get(Account account, User user){
        try (Connection conn = ConnectUtil.getConnection()){
            conn.setAutoCommit(false);

            String sql = "SELECT * from accounts WHERE user_id = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user.getId());

            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                int id = resultSet.getInt("id");

                account.setBalance(balance);
                account.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account updateBalance(Account account, double balance, double amount) {
        double newBalance = balance + amount;
        try (Connection conn = ConnectUtil.getConnection()){
            conn.setAutoCommit(false);

            String sql = "UPDATE accounts SET balance = ? WHERE id = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, newBalance);
            statement.setInt(2, account.getId());

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
