package se.soundgood.main;

import se.soundgood.view.View;

public class Main {
    public static void main(String... args) {
        try {
            View view = new View();
            Run run = new Run();

            System.out.println("Soundgood Database CLI (1.0)");
            System.out.println("Type \"help\" for help \n");
            while (run.getRun()) {
                view.Menu(run);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}