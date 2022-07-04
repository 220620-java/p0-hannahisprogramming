package main.BankApp.data;

import main.BankApp.db.Connect;
import main.BankApp.models.User;

import java.sql.PreparedStatement;

public class UserSQL implements UserDao {
    private Connect connection = Connect.connectToDb();

    @Override
    public User create(User user) {
        try (connection) {
            String sql = "insert into bank.users" + "(id, username, password)" + "values (default, ?, ?)";
            String[] keys = {"id"};

            PreparedStatement stmt = connection.prepareStatement(sql, keys);
        }
    }
}
