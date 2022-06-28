package main.BankApp.Users;

import main.BankApp.Queries.SQL;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private double balance;
    private boolean loggedin = false;
    private boolean loginfail = false;

    //declare & instantiate sql
    static SQL sql = new SQL();

    //------------------------ methods -----------------------
    //create account
    public void createAccount(User user) {
        //
    }
    //login
    public void login(User user){
        //
    }

    //deposit
    public void deposit(User user, double amount) {
        //
    }

    //withdraw
    public void withdraw (User user, double amount){
        //
    }

    //------------------------ classes -----------------------
    public User (){

    }

    //------------------------ getters & setters -----------------------


}
