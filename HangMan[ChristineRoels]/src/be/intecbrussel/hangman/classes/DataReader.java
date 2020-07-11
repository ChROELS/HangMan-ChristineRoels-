package be.intecbrussel.hangman.classes;

import be.intecbrussel.hangman.interfaces.DataProviderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class DataReader implements DataProviderService {
    private final int AMOUNTOfGuesses = 18;
    private String goal;
    private String conditionOfSuccess;
    private String amountOfGuessesRule;
    private final Random randomizedSelection = new Random();
    private String wordToDiscover;

    public DataReader(){
        try(FileReader rulesFile = new FileReader("hangManRules.conf");
            BufferedReader linesFile = new BufferedReader(rulesFile)) {
            String line = linesFile.readLine();
            goal = line;
            line = linesFile.readLine();
            conditionOfSuccess = line;
            line = linesFile.readLine();
            amountOfGuessesRule = line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileReader wordsFile = new FileReader("hangManWords.conf");
            BufferedReader linesFiles = new BufferedReader(wordsFile)) {
            int index = randomizedSelection.nextInt(5);
            String line= linesFiles.readLine();
            for(int i = 0; i<index;i++) {
                line = linesFiles.readLine();
            }
            wordToDiscover = line;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String randomWords() {
        try(FileReader wordsFile = new FileReader("hangManWords.conf");
            BufferedReader linesFiles = new BufferedReader(wordsFile)) {
            int index = randomizedSelection.nextInt(5);
            String line= linesFiles.readLine();
            for(int i = 0; i<index;i++) {
                line = linesFiles.readLine();
            }
            wordToDiscover = line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  wordToDiscover;
    }
    @Override
    public void displayRules() {
        System.out.println(String.format("%s %n%s %n%s", goal, conditionOfSuccess, amountOfGuessesRule));
    }
    @Override
    public void displayGameSet() {
        System.out.println("Try to reveal the following word:");
        System.out.print("-".repeat(wordToDiscover.length())+"\n");
    }
    @Override
    public int getAmountOfGuesses() {
        return AMOUNTOfGuesses;
    }
    @Override
    public String getWordToDiscover() {
        return wordToDiscover;
    }
}
