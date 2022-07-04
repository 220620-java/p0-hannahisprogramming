package main.BankApp.data;

import main.BankApp.models.User;

public interface UserDao {
    public User findByUsername(String username);
    public User create(User user);
}
