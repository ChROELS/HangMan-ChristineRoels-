package be.intecbrussel.hangman.io.wordsToDiscover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class ReadFiles {
    public static void main(String[] args) {
        /*try(FileReader wordsFile = new FileReader("hangManWords.conf");
            BufferedReader linesFiles = new BufferedReader(wordsFile)) {
            String line = linesFiles.readLine();
            while(line!=null) {
                System.out.println(line);
                line = linesFiles.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try(FileReader wordsFile = new FileReader("hangManWords.conf");
            BufferedReader linesFiles = new BufferedReader(wordsFile)) {
            Random randomizedSelection = new Random();
            int index = randomizedSelection.nextInt(5);
            String line= linesFiles.readLine();
            for(int i = 0; i<index;i++) {
                    line = linesFiles.readLine();

            }
            String wordToDiscover = line;
            System.out.println(wordToDiscover);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
