package be.intecbrussel.hangman.interfaces;

public interface OutputService {
    void printScore();
    int updateScore();
    void updatePenalty();
    void displayHangedMan();
    void displaySavedMan();
}
