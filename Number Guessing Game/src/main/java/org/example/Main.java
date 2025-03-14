package org.example;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int randomNumber = randomNumber();
        int oportunity = 0;
        int dificultyLevel = dificultyLevel();
        StopWatch stopWatch = new StopWatch();

        System.out.println(randomNumber);

        switch (dificultyLevel) {
            case 1:
                oportunity = 5;
                break;
            case 2:
                oportunity = 3;
                break;
            case 3:
                oportunity = 2;
                break;
            default:
                break;
        }

        stopWatch.start();
        do {

            System.out.println("< ----------------------------------------- >");
            System.out.print("Enter a number between 1 and 100: ");
            int number = sc.nextInt();

            if (number != randomNumber) {
                verifyNumber(number, randomNumber);
                counter++;
                System.out.println("You have " + (oportunity - counter) + " chance left");
            } else {
                stopWatch.stop();
                System.out.println("Congratulations! you have guessed the number!");
                System.out.println("Your time was: "
                        + (stopWatch.getTime(TimeUnit.SECONDS) / 60) + " minutes "
                        + (stopWatch.getTime(TimeUnit.SECONDS) % 60) + " seconds");
                System.out.println(" Do you want play again?");
                System.out.println("| 1. Yes | --- | 2. No |");
                int guess = sc.nextInt();
                switch (guess) {
                    case 1:
                        counter = 0;
                        dificultyLevel = dificultyLevel();
                        randomNumber = randomNumber();
                        stopWatch.reset();
                        break;
                    case 2:
                        return;
                }
            }

            if (counter == oportunity) {
                System.out.println("Oops! You failed. Do you want to try again?");
                System.out.println("| 1. Yes | --- | 2. No |");
                int guess = sc.nextInt();
                switch (guess) {
                    case 1:
                        counter = 0;
                        break;
                    case 2:
                        break;
                }
            }

        } while (counter < oportunity);
    }

    public static int randomNumber() {
        return (int) (Math.random() * 100);
    }

    public static void verifyNumber(int number, int randomNumber) {
        if (number > randomNumber) {
            System.out.println("Incorrect! The number is less than " + number);
        } else if (number < randomNumber) {
            System.out.println("Incorrect! The number is greater than " + number);
        }
    }

    public static int dificultyLevel() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" <----------------------------------------------------->");
        System.out.println("Select the difficulty level:");
        System.out.println("1. Easy (5 Opportunities )");
        System.out.println("2. Medium (3  Opportunities )");
        System.out.println("3. Hard (2  Opportunities )");
        System.out.println(" <----------------------------------------------------->");
        return sc.nextInt();
    }
}