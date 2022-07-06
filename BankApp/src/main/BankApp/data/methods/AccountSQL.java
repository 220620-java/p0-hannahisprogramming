package main.BankApp.data.methods;

import main.BankApp.data.interfaces.AccountDao;
import main.BankApp.utils.ConnectUtil;
import main.BankApp.models.Account;
import main.BankApp.models.User;

import java.sql.*;

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

//    @Override
//    public Account get(Account account, User user){
//        try (Connection conn = ConnectUtil.getConnection()){
//            conn.setAutoCommit(false);
//
//            String sql = "select * from accounts where user_id = ?;";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, user.getId());
//
//            ResultSet resultSet = statement.executeQuery();
//            if(resultSet.next()) {
//                double balance = resultSet.getDouble("balance");
//                int id = resultSet.getInt("id");
//
//                account.setBalance(balance);
//                account.setId(id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return account;
//    }

    @Override
    public Account getAccountInfo(User user) {
        Account account = new Account();
        int userId = user.getId();
        try (Connection conn = connUtil.getConnection()) {
            conn.setAutoCommit(false);

            String sql = "select * from accounts where user_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int setId = resultSet.getInt("id");
                String setType = resultSet.getString("account_type");
                double setBalance = resultSet.getDouble("balance");
                int setUserId = resultSet.getInt("user_id");

                account = new Account(setId, setType, setBalance, setUserId);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account updateBalance(Account account, double balance, String transType, double amount) {
        double newBalance;
        if (transType == "Deposit") {
            newBalance = balance + amount;
        } else if ((balance - amount) < 0){
            System.out.println(
                    "-------------------------------------------\n"
                    + "You are trying to overdraw your account!\n"
                    + "-------------------------------------------\n"
            );
            newBalance = balance;
        } else {
            newBalance = balance - amount;
        }
        System.out.println(newBalance);

        try (Connection conn = ConnectUtil.getConnection()){
            conn.setAutoCommit(false);
            int accountId = account.getId();
            String sql = "update accounts set balance = ? where id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, newBalance);
            statement.setInt(2, accountId);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
