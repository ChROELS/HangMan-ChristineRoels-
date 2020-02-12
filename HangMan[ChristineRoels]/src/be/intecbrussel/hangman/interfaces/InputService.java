package be.intecbrussel.hangman.interfaces;

public interface InputService {
    void saveUserName();
    void saveUserChoice();
    String getUserName();
    void saveUserLetter();
    String getUserLetter();
    char getUserChoice();
}
