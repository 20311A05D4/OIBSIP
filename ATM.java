package org.example.oasis;

import java.util.Scanner;

public class ATM {
    static Scanner sc=new Scanner(System.in);
    static int balance=1000;
   static int deposit,withdraw;
    public static void main(String[] args) {

        System.out.print("Your name:");
        String userid=sc.nextLine();
        System.out.print("Create a 4 digit pin to your account:");
        int pin=sc.nextInt();
        System.out.println();
        System.out.println("********* Hello "+userid+" Pin created sucessfully ***********");
        System.out.println();
        System.out.println("------ATM-------");
        System.out.println();
        int attemps=3;
        while(attemps > 0){
            if(checkdetails(userid,pin)){
                break;
            }
            attemps--;
        }
        if(attemps == 0){
            System.out.println("You have exceeded the limit.. try again after sometime!!!");
            return;
        }
        menu();
    }
    private static void menu(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Select the operation you want to perform..");
        System.out.println("1. Withdraw money");
        System.out.println("2. Deposit money");
        System.out.println("3. Check A/c balance");
        System.out.println("4. Exit");
        int choice=sc.nextInt();

        switch(choice){
            case 1:withdrawmoney();
                   break;
            case 2:depositmoney();
                   break;
            case 3:checkbalance();
                   break;
            case 4:break;
            default:System.out.println("Please enter a valid option:");
                    menu();

        }
    }
    private static void checkbalance() {
        System.out.println();
        System.out.println();
        System.out.println("****** Your current balance is:"+balance+" ******");
        menu();
    }

    private static void depositmoney() {
        System.out.print("Enter the amount you want to deposit:");
        deposit=sc.nextInt();
        if(deposit < 0){
            System.out.println("Invalid Amount");
            menu();
            return;
        }
        balance+=deposit;
        System.out.println("Successfull");
        menu();
    }

    private static void withdrawmoney() {
        System.out.print("Enter the amount you want to withdraw:");
        withdraw=sc.nextInt();
        if(withdraw > balance){
            System.out.println("Insufficient funds");
            menu();
            return;
        }
        balance-=withdraw;
        System.out.println("Successfull");
        menu();
    }

    public static boolean checkdetails(String userid,int pin){
        System.out.print("Enter your userID:");
        String newuserid=sc.next();
        if(!userid.equals(newuserid)){
            System.out.println("Invalid user details:");
            return false;
        }
        System.out.print("Enter your pin:");
        int newpin=sc.nextInt();
        if(pin != newpin){
            System.out.println("Invalid user details:");
            return false;
        }
        return true;
    }
}
