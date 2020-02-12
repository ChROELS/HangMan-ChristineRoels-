package be.intecbrussel.hangman.classes;

import be.intecbrussel.hangman.interfaces.DataProviderService;

import java.util.Random;

public class StaticDataProvider implements DataProviderService {
    private int amountOfGuesses;
    private String goal;
    private String conditionOfSuccess;
    private String amountOfGuessesRule;
    private Random randomizedSelection;
    private String[] wordsAvailable;
    private String wordToDiscover;

    public StaticDataProvider() {
        goal = "You are the last hope for a man put on trial in front of a jury. Guess all the letters of the hidden english word suggested by the _ signs to save this man life. There will be no space, no punctuation.";
        amountOfGuesses = 18;
        conditionOfSuccess = "Each time you guess wrong, one jury member makes up his mind and will vote for death by hang! Beware, the challenge is quite HARD! ";
        amountOfGuessesRule = "You have "+ amountOfGuesses+ " guesses available. Once you have found the word, enter one of the words letter to see your score.";
        randomizedSelection = new Random();
        wordsAvailable = new String[]{"supercalifragilisticexpialidocious","strengths","copyrightable","unimaginatively","establishment"};
        int index = randomizedSelection.nextInt(5);
        wordToDiscover = wordsAvailable[index];
    }

    @Override
    public String randomWords() {
        int index2 = randomizedSelection.nextInt(5);
        return wordsAvailable[index2];
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
        return amountOfGuesses;
    }

    @Override
    public String getWordToDiscover() {
        return wordToDiscover;
    }


}
