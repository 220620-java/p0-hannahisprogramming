package main.BankApp.data.methods;

import main.BankApp.data.interfaces.TransDao;
import main.BankApp.dataStructure.ArrayList;
import main.BankApp.dataStructure.List;
import main.BankApp.models.Account;
import main.BankApp.models.Transaction;
import main.BankApp.utils.ConnectUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransSQL implements TransDao {
    @Override
    public Transaction create(Transaction transaction, int id, String transType, double amount, Account account){
        try (Connection conn = ConnectUtil.getConnection()){
            conn.setAutoCommit(false);

            String sql = "insert into transactions" + "(id, trans_type, amount, user_id)" + "values (default, ?, ?, ?)";
            String[] keys = {"id"};

            PreparedStatement statement = conn.prepareStatement(sql, keys);
            statement.setString(1, transType);
            statement.setDouble(2, amount);
            statement.setInt(3, account.getId());

            int rowsAffected = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next() && rowsAffected == 1) {
                transaction.setId(resultSet.getInt("id"));
                transaction.setTransType(transType);
                transaction.setAmount(amount);
                conn.commit();
            } else {
                conn.rollback();
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    @Override
    public List<Transaction> findByAccount(Account account){
        List<Transaction> transactionList = new ArrayList<>();

        try (Connection conn = ConnectUtil.getConnection()){
            conn.setAutoCommit(false);

            String sql = "SELECT * from transactions WHERE account_id = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, account.getId());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String transType = resultSet.getString("trans_type");
                double amount = resultSet.getDouble("amount");

                Transaction transaction = new Transaction(id, transType, amount, account);
                transactionList.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }

}
