package main.BankApp.data.methods;

import main.BankApp.data.interfaces.UserDao;
import main.BankApp.models.User;
import main.BankApp.utils.ConnectUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSQL implements UserDao {
    private ConnectUtil connUtil = ConnectUtil.getConnectUtil();

    @Override
    public User create(User user) {
        try (Connection conn = connUtil.getConnection()) {
            conn.setAutoCommit(false);

            String sql = "insert into users" + "(id, username, password)" + "values (default, ?, ?)";
            String[] keys = {"id"};

            PreparedStatement stmt = conn.prepareStatement(sql, keys);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            int rowsAffected = stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if(resultSet.next() && rowsAffected == 1) {
                user.setId(resultSet.getInt("id"));
                conn.commit();
            } else {
                conn.rollback();
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

        try (Connection conn = connUtil.getConnection()) {
            conn.setAutoCommit(false);

            String sql = "SELECT * from users WHERE username = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

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
