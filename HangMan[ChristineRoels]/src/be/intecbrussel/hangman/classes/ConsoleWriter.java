package be.intecbrussel.hangman.classes;

import be.intecbrussel.hangman.interfaces.OutputService;

public class ConsoleWriter implements OutputService {
   private int userScore;


    public ConsoleWriter() {
        userScore=0;
    }

    @Override
    public void printScore() {
        System.out.println(userScore);
    }

    @Override
    public int updateScore() {
        return ++userScore;
    }

    @Override
    public void updatePenalty() {
        System.out.println("I vote FOR!");
    }

    @Override
    public void displayHangedMan() {
        System.out.println("|");
        System.out.println("|--------------------------------------");
        System.out.println("|______________________________________|");
        System.out.println("|                   |");
        System.out.println("|                   |");
        System.out.println("|                   |");
        System.out.println("|                   |");
        System.out.println("|                   |");
        System.out.println("|                 ----");
        System.out.println("|                /    \\");
        System.out.println("|               { x . x }");
        System.out.println("|               \\  ~  /");
        System.out.println("|                 ----");
        System.out.println("|                  ||");
        System.out.println("|              ------------");
        System.out.println("|             / |       |\\");
        System.out.println("|             | |       |  |");
        System.out.println("|             | |       |  |");
        System.out.println("|             | |       |  |");
        System.out.println("|             [ |       |  ]");
        System.out.println("|               |       |  ");
        System.out.println("|               ---------");
        System.out.println("|              / /    \\\\");
        System.out.println("|             / /      \\\\");
        System.out.println("|            / /        \\\\");
        System.out.println("|            | |         | |");
        System.out.println("|            \\\\        / /");
        System.out.println("|             \\\\      / /");
        System.out.println("|              \\\\    / /");
        System.out.println("|             ---  |  |  ---");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|____________________________________________");
    }
    @Override
    public void displaySavedMan() {

        System.out.println("|                 ----");
        System.out.println("|                /    \\");
        System.out.println("|               { [] .[] }  ♡");
        System.out.println("|               \\   +  /   Thank you!");
        System.out.println("|                 ----");
        System.out.println("|                  ||");
        System.out.println("|              ------------");
        System.out.println("|             / |       |\\");
        System.out.println("|             | |       |  |");
        System.out.println("|             | |       |  |");
        System.out.println("|             | |       |  |");
        System.out.println("|             [ |       |  ]");
        System.out.println("|               |       |  ");
        System.out.println("|               ---------");
        System.out.println("|              / /    \\\\");
        System.out.println("|             / /      \\\\");
        System.out.println("|            / /        \\\\");
        System.out.println("|            | |         | |");
        System.out.println("|            | |         | |");
        System.out.println("|            | |         | |");
        System.out.println("|            | |         | |");
        System.out.println("|         ---  |         |  ---");
        System.out.println("|____________________________________________");
    }
}
