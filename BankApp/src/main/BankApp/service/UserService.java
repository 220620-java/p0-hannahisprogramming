package main.BankApp.service;

import main.BankApp.data.interfaces.UserDao;
import main.BankApp.data.methods.UserSQL;
import main.BankApp.models.User;

public class UserService {
    private UserDao userDao;
    public UserService() { userDao = new UserSQL(); }

    //add username exception
    //@Override
    public User create(int id, String name, String username, String password) {
        User user;
        user = new User(id, name, username, password);
        return user;
    }

    //@Override
    public User findByUsername(String username) {return userDao.findByUsername(username);}
}
