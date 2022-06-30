package main.BankApp.Accounts;

import main.BankApp.Users.User;

public class Account {
    //------------------------ variables -----------------------
    //------------------------ methods -----------------------
    public void createAccount(User user) {
        //
    }
    //------------------------ classes -----------------------
    //------------------------ getters & setters -----------------------
    //get & set account number------------------------------------------------------------------
    public int getAccountNum(){
        return accountNumber;
    }
    public void setAccountNum(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    //get & set account type------------------------------------------------------------------
    public String getAccountType(){
        return accountType;
    }
    public void setAccountType(String accountType){
        this.accountType = accountType;
    }
}
