package main.BankApp.models;

import java.util.Scanner;

public class Transaction {
    //------------------------ variables -----------------------
    static Scanner scanner = new Scanner(System.in);
    private int id, accountId;
    private String transType;
    private double amount;
    //------------------------ classes -----------------------
    public Transaction() {
        super();
        this.id = 0;
        this.transType = "";
        this.amount = 0;
        this.accountId = 0;
    }
    public Transaction(int id, String transType, double amount, Account account){
        super();
        this.id = id;
        this.transType = transType;
        this.amount = amount;
        this.accountId = account.getId();
    }
    //------------------------ methods -----------------------
    public void createTransaction(Account account) {
        String transType;
        System.out.println("Would you like to make a Deposit(1) or a Withdrawal(2)?");
        int selection = scanner.nextInt();
        String accountType;
        if (selection == 1) {
            transType = "Deposit";
        } else {
            transType = "Withdrawal";
        }
        System.out.println("How much would you like your " + transType.toLowerCase() + " to be?");
        double amount = scanner.nextDouble();
        Transaction transaction = new Transaction(id, transType, amount, account);
    }

    //------------------------ getters & setters -----------------------
    //get & set trans id------------------------------------------------------------------
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    //get & set trans type------------------------------------------------------------------
    public String getTransType(){ return transType; }
    public void setTransType(String transType){ this.transType = transType; }

    //get & set trans amount------------------------------------------------------------------
    public double getAmount(){ return amount; }
    public void setAmount(double amount){ this.amount = amount; }
}
