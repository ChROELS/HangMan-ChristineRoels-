package be.intecbrussel.hangman.io.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("game.conf")){
            Properties properties = new Properties();
            properties.setProperty("wordsPath","C:\\Users\\Christine Roels\\IdeaProjects\\HangMan[ChristineRoels]\\hangManWords.conf");
            properties.setProperty("rulesPath","C:\\Users\\Christine Roels\\IdeaProjects\\HangMan[ChristineRoels]\\hangManRules.conf");
            properties.setProperty("Language","English");
            properties.setProperty("maxTries","18");
            properties.store(out,"Game configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
