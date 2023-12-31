package se.soundgood.view;

import org.jooq.exception.DataAccessException;
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

            String src = scanner.nextLine().replaceAll("\\s+", " ").trim().toUpperCase();
            if (src.isEmpty()) {
                continue;
            }
            cmd.interpret(src);

            try {
                switch (cmd.getCmd()) {
                    case LIST_INST -> {
                        var res = controller.listInstruments(cmd.getType());
                        System.out.print(res.toString());
                        if (res.size() > 50) {
                            System.out.println("|..." + (res.size() - 50) + " record(s) not shown...");
                        }
                    }
                    case RENT -> {
                        controller.rentInstrument(cmd.getId1(), cmd.getId2());
                        System.out.printf("Success, student (id = %s) rented instrument (id = %s)\n", cmd.getId1(), cmd.getId2());
                    }
                    case LIST_LEASE -> {
                        var res = controller.listLeases(cmd.getId1());
                        System.out.println(res);
                        if (res.size() > 50) {
                            System.out.println("|..." + (res.size() - 50) + " record(s) not shown...");
                        }
                    }
                    case TERMINATE -> {
                        controller.terminateRental(cmd.getId1());
                        System.out.printf("Success, rental (id = %s) is terminated as of today\n", cmd.getId1());
                    }
                    case HELP -> help();
                    case QUIT -> {
                        System.out.println("\nProgram shutting down");
                        System.out.print("Press 'Enter' to continue...");
                        scanner.nextLine();
                        run = false;
                    }
                    case UNK_CMD -> System.out.println(cmd.getReason());
                }
            } catch (DataAccessException e) {
                if (e.sqlState().equals("08006") || e.sqlState().equals("08003")) {
                    System.out.println("[ERROR] SQL State (" + e.sqlState() + ")" );
                } else {
                    System.out.println("[Failed] " + e.getMessage());
                }
                if(e.getCause() != null){
                    System.out.println( "Because " + e.getCause().getMessage());
                }
            }
            System.out.println();
        }
    }

    private void help() {
        System.out.println("""
                Command: LIST_INST
                Description: Lists all rentable instruments, can be filtered by instrument type
                Syntax: [LIST_INST (Instype)]
                """);
        System.out.println("""
                Command: RENT
                Description: Rents an instrument given a valid student and instrument ID
                Syntax: [RENT [StudentID] [InstrumentID]]
                """);
        System.out.println("""
                Command: LIST_LEASE
                Description: Lists all active leases, can be filtered by student ID
                Syntax: [LIST_LEASE (StudentID)]
                """);
        System.out.println("""
                Command: TERMINATE
                Description: Terminates an active rental given a valid lease ID
                Syntax: [TERMINATE [LeaseID]]
                """);
        System.out.println("""
                Command: HELP
                Description: Shows this help menu
                Syntax: [HELP]
                """);
        System.out.print("""
                Command: QUIT
                Description: Quits the program
                Syntax: [QUIT]
                """);
    }
}
