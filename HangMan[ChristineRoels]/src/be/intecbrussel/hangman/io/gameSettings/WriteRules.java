package be.intecbrussel.hangman.io.gameSettings;

import java.io.FileWriter;
import java.io.IOException;

public class WriteRules {
    public static void main(String[] args) {
        String[] rules;
        final int AMOUNTOfGuesses = 18;
        try(FileWriter wordsFile = new FileWriter("hangManRules.conf",true)){
            rules = new String[]{"You are the last hope for a man put on trial in front of a jury. " +
                    "Guess all the letters of the hidden english word suggested by the _ signs to save this man life. There will be no space, no punctuation.",
                    "Each time you guess wrong, one jury member makes up his mind and will vote for death by hang! Beware, the challenge is quite HARD! ",
            "You have "+ AMOUNTOfGuesses+ " guesses available."};
            for (String ele: rules
            ) {
                wordsFile.write(ele +"\n");
            }
        }catch (IOException ioe){
            ioe.getStackTrace();
        }
    }
}
