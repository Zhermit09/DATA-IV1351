package se.soundgood.main;

import se.soundgood.controller.Controller;
import se.soundgood.view.View;

public class Main {
    public static void main(String... args) {
        try {
            View view = new View(new Controller());
            view.Menu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}