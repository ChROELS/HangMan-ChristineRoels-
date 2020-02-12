package be.intecbrussel.hangman.io.gameSettings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadRules {
    public static void main(String[] args) {
        try(FileReader rulesFile = new FileReader("hangManRules.conf");
            BufferedReader linesFile = new BufferedReader(rulesFile)) {
            String line = linesFile.readLine();
            while(line!=null) {
                System.out.println(line);
                line = linesFile.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
