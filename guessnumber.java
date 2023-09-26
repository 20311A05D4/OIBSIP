package org.example.oasis;

import java.util.Random;
import java.util.Scanner;

public class guessnumber {
    public static void main(String[] args) {
        guess();
    }

    private static void guess() {
        Random random=new Random();
        int randomnumber= random.nextInt(1,101);
        Scanner sc=new Scanner(System.in);
        int attempt=1;
        int score=0;
        do{
            System.out.print("Enter your guess number between 1 to 100 :");
            int guessednumber=sc.nextInt();
            if(guessednumber == randomnumber){
                System.out.println();
                System.out.println("*****Wow.. you have guessed correct Congratulations.. ****");
                System.out.println();
                score=score+100;
                break;
            }
            if(guessednumber < randomnumber){

                System.out.println("Oops you have guessed lesser number..");
                System.out.println();
            }
            if(guessednumber > randomnumber){

                System.out.println("Oops you have guessed greater number..");
                System.out.println();
            }

            attempt++;
        }while(attempt<=5);
        if(attempt == 6){
            System.out.println();
            System.out.println("!!!!!! You lost the game !!!!");
        }
        System.out.println("Secret number is:"+randomnumber);
        System.out.println("Your score is:"+score);
        System.out.println("Try again after some time");
        System.out.println();
        System.out.print("If you want to play the game again press 1 otherwise enter 0 : ");
        int num=sc.nextInt();
        if(num == 1)
            guess();

    }


}
