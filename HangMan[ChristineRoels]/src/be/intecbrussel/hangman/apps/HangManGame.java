package be.intecbrussel.hangman.apps;

import be.intecbrussel.hangman.classes.ConsoleReader;
import be.intecbrussel.hangman.classes.ConsoleWriter;
import be.intecbrussel.hangman.classes.DataReader;
import be.intecbrussel.hangman.interfaces.DataProviderService;
import be.intecbrussel.hangman.interfaces.InputService;
import be.intecbrussel.hangman.interfaces.OutputService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;


public class HangManGame implements Serializable {
    private static InputService inputService;
    private static OutputService outputService;
    private static DataProviderService dataProviderService;

    public HangManGame() {
        inputService = new ConsoleReader();
        outputService = new ConsoleWriter();
        dataProviderService = new DataReader();
    }

    public void startGame(){
        inputService.saveUserName();
        dataProviderService.displayRules();
    }
    public void playGame() {
        String wordToDiscover = dataProviderService.getWordToDiscover();
        int amountOfGuesses = dataProviderService.getAmountOfGuesses();
        boolean letterIsInWord;
        char[] lettersOfUser;
        int anotherGameRound = 0;
        int score = 0;
        while (anotherGameRound < 5) {
            dataProviderService.displayGameSet();
            lettersOfUser = new char[wordToDiscover.length()];
            do {
                //user guesses char
                inputService.saveUserLetter();
                //Display letter
                System.out.println("Your letter: " + inputService.getUserLetter());
                //Char is in word?
                letterIsInWord = wordToDiscover.contains(inputService.getUserLetter());
                //Consequences...
                if (!letterIsInWord) {
                    // penalty +1
                    System.out.printf("%n '%s' is not in the word! The death penalty has gained a voice: ", inputService.getUserLetter());
                    outputService.updatePenalty();
                    //amount of guesses -1
                    amountOfGuesses--;
                    System.out.printf("You still have %d chances to win!", (amountOfGuesses));
                    if (amountOfGuesses == 0) {
                        System.out.printf("%n You have lost! The death penalty has been applied!");
                        System.out.println("Your score is: " + score);
                        outputService.displayHangedMan();
                    }

                } else {
                    for (int i = 0; i < wordToDiscover.toCharArray().length; i++) {
                        if (inputService.getUserLetter().toCharArray()[0] == wordToDiscover.toCharArray()[i]) {
                            // showing where the letter is in the word
                            lettersOfUser[i] = inputService.getUserLetter().toCharArray()[0];
                            System.out.println(Arrays.toString(lettersOfUser));
                        }
                    }
                    // score +1
                    score = outputService.updateScore();
                    System.out.println("Let's continue!");
                    // if the word is complete
                    if (Arrays.equals(lettersOfUser, wordToDiscover.toCharArray())) {
                        System.out.printf("The word to discover was indeed %s.%n", wordToDiscover);
                        System.out.println("You have just saved this man live!😇");
                        System.out.println("Your score is: " + score);
                        System.out.println("It took you " + (20 - amountOfGuesses) + " rounds of argumentation to convince them.");
                        outputService.displaySavedMan();
                        amountOfGuesses = 0;
                    } else {
                        //amount of guesses-1
                        amountOfGuesses--;
                        if (amountOfGuesses == 0) {
                            System.out.printf("%n You have lost! The death penalty has been applied!");
                            System.out.println("Your score is: " + score);
                            outputService.displayHangedMan();
                        } else {
                            System.out.printf("You still have %d chances to win!", (amountOfGuesses));
                        }
                    }
                }
                //Saving user stats
                savingUserStats(wordToDiscover,score);
            } while (amountOfGuesses > 0);
            //Launching another game round
            launchingAnotherGameRound(wordToDiscover, amountOfGuesses, anotherGameRound);
        }
    }
    private static void savingUserStats (String wordToDiscover, int score) {
        System.out.println("A File will be created with your name, word to discover and score.");
        try (FileWriter userFile = new FileWriter("userFile.conf", true)) {
            userFile.write(inputService.getUserName());
            userFile.write(wordToDiscover);
            userFile.write(score);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    private static void launchingAnotherGameRound(String wordToDiscover, int amountOfGuesses, int anotherGameRound){
        System.out.println("Would you like to save another man? Y or N: ");
        inputService.saveUserChoice();
        if (inputService.getUserChoice() == 'Y') {
            wordToDiscover = dataProviderService.randomWords();
            amountOfGuesses = 18;
            anotherGameRound++;
        } else {
            anotherGameRound=5;
            showScore();
            System.out.println("See you next time!");
        }
    }
    private static void showScore(){
        System.out.println("Your score is: ");
        outputService.printScore();
    }

}
