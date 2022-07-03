package main.BankApp.models;

import main.BankApp.models.User;

import java.util.Scanner;

public class Account {
    //------------------------ variables -----------------------
    static Scanner scanner = new Scanner(System.in);
    private int id;
    private String accountType;
    private double balance;
    //------------------------ classes -----------------------
    public Account() {
        super();
        this.id = 0;
        this.accountType = "";
        this.balance = 0;
    }
    public Account(String accountType, double balance){
        super();
        //this.id = id;
        this.accountType = accountType;
        this.balance = balance;
    }
    //------------------------ methods -----------------------
    public void createAccount(User user) {
        System.out.println("Would you like a Savings(1) or Checking account(2)?");
        int selection = scanner.nextInt();
        String accountType;
        if (selection == 1) {
            accountType = "Savings";
        } else {
            accountType = "Checking";
        }
        System.out.println("How much would you like your initial deposit to be?");
        double balance = scanner.nextDouble();
        Account account = new Account(accountType, balance);

    }

    //------------------------ getters & setters -----------------------
    //get & set account number------------------------------------------------------------------
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //get & set account type------------------------------------------------------------------
    public String getAccountType(){
        return accountType;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }

    //get & set balance------------------------------------------------------------------
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
}
