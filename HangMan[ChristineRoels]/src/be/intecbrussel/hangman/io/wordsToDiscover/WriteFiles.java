package be.intecbrussel.hangman.io.wordsToDiscover;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFiles {
    public static void main(String[] args) {
        String[] wordsAvailable;
        try(FileWriter wordsFile = new FileWriter("hangManWords.txt",true)){
            wordsAvailable = new String[]{"supercalifragilisticexpialidocious","strengths","copyrightable","unimaginatively","establishment"};
            for (String ele: wordsAvailable
                 ) {
                wordsFile.write(ele +"\n");
            }
        }catch (IOException ioe){
            ioe.getStackTrace();
        }
        try(FileWriter wordsFile = new FileWriter("hangManWords.conf",true)){
            wordsAvailable = new String[]{"supercalifragilisticexpialidocious","strengths","copyrightable","unimaginatively","establishment"};
            for (String ele: wordsAvailable
            ) {
                wordsFile.write(ele +"\n");
            }
        }catch (IOException ioe){
            ioe.getStackTrace();
        }
    }
}
