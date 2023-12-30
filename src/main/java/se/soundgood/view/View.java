package se.soundgood.view;

import se.soundgood.controller.Controller;

import java.util.Scanner;


public class View {
    private final Scanner scanner = new Scanner(System.in);
    private final Controller controller;

    public View(Controller cont) throws RuntimeException {
        controller = cont;
    }

    public void Menu() {
        boolean run = true;
        CmdInterpreter cmd = new CmdInterpreter();

        System.out.println("Soundgood Database CLI (1.0)");
        System.out.println("Type \"help\" for help \n");

        while (run) {

            System.out.print("Input: ");

            String src = scanner.nextLine().trim().toUpperCase();
            if (src.isEmpty()) {
                continue;
            }
            cmd.interpret(src);

            try {
                switch (cmd.getCmd()) {
                    case LIST_INST -> {
                        var res = controller.listInstruments(cmd.getType());
                        System.out.print(res.toString());
                        System.out.println("|..." + (res.size() - 50) + " record(s) not shown...");
                    }
                    case RENT -> {
                        controller.rentInstrument(cmd.getId1(), cmd.getId2());
                        System.out.println("Success, student (id = {cmd.getId1()}) rented instrument (id = {cmd.getId2()})");
                    }
                    case LIST_LEASE -> {
                        var res = controller.listLeases(cmd.getId1());
                        System.out.println(res);
                        System.out.println("|..." + (res.size() - 50) + " record(s) not shown...");
                    }
                    case TERMINATE -> System.out.println("Term");
                    case HELP -> System.out.println("Help");
                    case QUIT -> {
                        System.out.println("\nProgram shutting down");
                        System.out.println("Press 'Enter' to continue...");
                        scanner.nextLine();
                        run = false;
                    }
                    case UNK_CMD -> System.out.println("Unknown");
                }
            }catch (Exception e){

            }
        }
    }


}
