package se.soundgood.view;

import se.soundgood.controller.Controller;
import se.soundgood.main.Run;


public class View {
    private final Controller controller;

    public View() throws RuntimeException {
        controller = new Controller();
    }

    public void Menu(Run run) {
        System.out.print("Input: ");
        System.out.print(controller.interact(run));
    }
}
