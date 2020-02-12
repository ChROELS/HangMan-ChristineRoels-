package be.intecbrussel.hangman.classes;

import be.intecbrussel.hangman.interfaces.InputService;

import java.util.Scanner;

public class ConsoleReader implements InputService {
    private char userChoice;
    private String userName;
    private String userLetter;
    private Scanner keyboard;

    public ConsoleReader() {
        userName = "";

        userLetter = "";
        userChoice = 'N';
        keyboard = new Scanner(System.in);
    }
    @Override
    public String getUserName() {
        return userName;
    }

    public String getUserLetter() {
        return userLetter;
    }

    @Override
    public char getUserChoice() {
        return userChoice;
    }

    @Override
    public void saveUserName() {
        System.out.println("Welcome to HANGMAN (revisited)! Enter your name: ");
        this.userName=keyboard.next();
    }

    @Override
    public void saveUserChoice() {
        System.out.println("Play again? Yes or No: ");
        userChoice = keyboard.next().toUpperCase().charAt(0);
    }


    @Override
    public void saveUserLetter() {
        System.out.println("Enter a letter: ");
        userLetter = keyboard.next().toLowerCase();
    }

    @Override
    public String toString() {
        return "ConsoleReader{" +
                "userChoice=" + userChoice +
                ", userName='" + userName + '\'' +
                ", userStatsChoice='" + '\'' +
                ", userLetter='" + userLetter +
                '}';
    }
}
