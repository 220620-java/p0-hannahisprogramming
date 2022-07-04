package main.BankApp.data;

import main.BankApp.db.Connect;
import main.BankApp.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSQL implements UserDao {
    private Connect connection = Connect.connectToDb();

    @Override
    public User create(User user) {
        try (connection) {
            String sql = "insert into bank.users" + "(id, username, password)" + "values (default, ?, ?)";
            String[] keys = {"id"};

            PreparedStatement stmt = connection.prepareStatement(sql, keys);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            int rowsAffected = stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if(resultSet.next() && rowsAffected == 1) {
                user.setId(resultSet.getInt("id"));
                connection.commit();
            } else {
                connection.rollback();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;

        try (connection) {
            String sql = "SELECT * from bank.users WHERE username = ?;";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int setId = resultSet.getInt("id");
                String setName = resultSet.getString("name");
                String setUsername = resultSet.getString("username");
                String setPassword = resultSet.getString("password");

                user = new User(setId, setName, setUsername, setPassword);
            } else {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
