package main.BankApp.models;

import java.util.Date;

public class Transaction {
    //------------------------ variables -----------------------
    private int id;
    private String transType;
    Date transDate = new Date();
    private double amount;
    //------------------------ classes -----------------------
    public Transaction() {
        this.id = 0;
        this.transType = "";
        this.transDate = new Date();
        this.amount = 0;
    }
    public Transaction(int id, String transType, Date transDate, double amount) {
        this.id = id;
        this.transType = transType;
        this.transDate = transDate;
        this.amount = amount;
    }
    //------------------------ methods -----------------------
    //deposit
    public void deposit(User user, double amount) {
        //
    }

    //withdraw
    public void withdraw (User user, double amount){
        //
    }

    //------------------------ getters & setters -----------------------
    //get & set amount------------------------------------------------------------------
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
}
