package se.soundgood.view;

import se.soundgood.controller.Controller;
import se.soundgood.main.Run;

import java.util.Scanner;


public class View {
    private final Controller controller;
    private final Scanner scanner;

    public View() throws RuntimeException {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public void Menu(Run run) {
        System.out.print("Input: ");
        String src = scanner.nextLine().replaceAll("\\s+", " ").trim().toUpperCase();
        System.out.print(controller.interact(src, run));
    }
}
