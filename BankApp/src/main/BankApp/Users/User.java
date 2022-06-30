package main.BankApp.Users;

import main.BankApp.Queries.SQL;

public class User {
    private int id;
    private String name, username, password;

    //private double balance = 0;
    private boolean loggedin = false;
    private boolean loginfail = false;

    //declare & instantiate sql
    static SQL sql = new SQL();

    //------------------------ methods -----------------------
    //login
    public void login(User user){
        //
    }

    //------------------------ classes -----------------------
    public User (){

    }

    //------------------------ getters & setters -----------------------
    //get & set id
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    //get & set name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //get & set username------------------------------------------------------------------
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    //get &set password------------------------------------------------------------------
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //get & set login------------------------------------------------------------------
    public boolean isLoggedin(){
        return loggedin;
    }
    public void setLoggedIn(boolean loggedin){
        this.loggedin = loggedin;
    }

    //get & set login failure------------------------------------------------------------------
    public boolean isLoginfail(){
        return loginfail;
    }
    public void setLoginfail(boolean loginfail){
        this.loginfail = loginfail;
    }
}
