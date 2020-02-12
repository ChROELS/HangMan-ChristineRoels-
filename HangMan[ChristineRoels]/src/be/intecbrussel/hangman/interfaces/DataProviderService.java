package be.intecbrussel.hangman.interfaces;

public interface DataProviderService {
    String randomWords();
    void displayRules();
    void displayGameSet();
    int getAmountOfGuesses();
    String getWordToDiscover();

}
