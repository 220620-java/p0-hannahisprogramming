package main.BankApp.Main;

//import ...

import main.BankApp.Users.User;

import java.util.Scanner;

public class Main {
    public static User user = new User();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean banking = true;

        while(banking) {
            //login menu
            if(!user.isLoggedin()) {
                System.out.println(
                        "----------------------------------------\n"
                        + "Welcome to The Bank\n"
                        + "----------------------------------------\n\n"
                        + "1. Login to my account\n"
                        + "2. Create an account\n"
                        + "3. Exit The Bank\n\n"
                        + "----------------------------------------\n\n"
                        + "What would you like to do?"
                );
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        //login();
                        break;
                    case 2:
                        //createAccount();
                        break;
                    case 3:
                        banking = false;
                        System.out.println("Thank you for using The Bank");
                }
            }
            //already logged in menu
            else {
                System.out.println(
                        " Welcome back to The Bank, " + user.getName() + "\n"
                        + "----------------------------------------------------\n"
                        + " Account Type: " + user.getAccountType() + "\n"
                        + "----------------------------------------------------\n"
                        + " Account No: " + user.getAccountNum() + "\n"
                        + "----------------------------------------------------\n"
                        + "	Account Balance: $" + user.getBalance() + "\n\n"
                        + "	1. Make Deposit\n"
                        + "	2. Make Withdrawal\n"
                        + "	3. Logout\n\n"
                        + "----------------------------------------------------\n"
                        + "What would you like to do?"
                );
                int selection = scanner.nextInt();
                switch(selection) {
                    case 1:
                        //deposit();
                        break;
                    case 2:
                        //withdraw();
                        break;
                    case 3:
                        System.out.println("Thank you for using our mobile banking!");
                        user.setLoggedIn(false);
                }
            }
        }
    }
}
