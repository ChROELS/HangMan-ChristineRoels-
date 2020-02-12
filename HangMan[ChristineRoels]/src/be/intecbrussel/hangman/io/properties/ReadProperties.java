package be.intecbrussel.hangman.io.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("game.conf")){
            Properties properties = new Properties();
            properties.load(in);
            properties.list(System.out);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
