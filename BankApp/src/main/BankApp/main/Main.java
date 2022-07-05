package main.BankApp.main;

import main.BankApp.models.Account;
import main.BankApp.models.User;
import main.BankApp.service.UserService;

import java.util.Scanner;

public class Main {
    public static Account account = new Account();
    public static UserService userServ = new UserService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean banking = true;
        User user = null;
        while(banking) {
            //login menu
            if(user == null) {
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
                        User newUser = new User();
                        newUser.createUser();
                        userServ.createUser(newUser);
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
                        + " Account Type: " + account.getAccountType() + "\n"
                        + "----------------------------------------------------\n"
                        + "	Account Balance: $" + account.getBalance() + "\n\n"
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
                        banking = false;
                }
            }
        }
    }
}
