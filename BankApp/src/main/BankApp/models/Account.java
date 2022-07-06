package main.BankApp.models;

import main.BankApp.models.User;

import java.util.Scanner;

public class Account {
    //------------------------ variables -----------------------
    static Scanner scanner = new Scanner(System.in);
    private int id, userId;
    private String type;
    private double balance;
    //------------------------ classes -----------------------
    public Account() {
        super();
        this.id = 0;
        this.type = "";
        this.balance = 0;
    }
    public Account(int id, String type, double balance, int userId){
        super();
        this.id = id;
        this.type = type;
        this.balance = balance;
        this.userId = userId;
    }
    //------------------------ methods -----------------------
    public void createAccount(User user) {
        System.out.println("Would you like a Savings(1) or Checking account(2)?");
        int selection = scanner.nextInt();
        String accountType;
        if (selection == 1) {
            type = "Savings";
        } else if (selection == 2) {
            type = "Checking";
        } else {
            type = "Checking";
        }
        System.out.println("How much would you like your initial deposit to be?");
        balance = scanner.nextDouble();
        Account account = new Account(id, type, balance, userId);
    }

    //------------------------ getters & setters -----------------------
    //get & set account number------------------------------------------------------------------
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    //get & set account type------------------------------------------------------------------
    public String getAccountType(){ return type; }
    public void setAccountType(String type){ this.type = type; }

    //get & set balance------------------------------------------------------------------
    public double getBalance(){ return balance; }
    public void setBalance(double balance){ this.balance = balance; }
}
