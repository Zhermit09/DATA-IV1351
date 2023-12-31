package se.soundgood.controller;

import org.jooq.exception.DataAccessException;
import se.soundgood.jooq.enums.Instype;
import se.soundgood.main.Run;
import se.soundgood.service.Service;

import static se.soundgood.controller.Command.UNK_CMD;

public class Controller {
    private Command cmd;
    private Long id1;
    private Long id2;
    private Instype type;
    private String reason;

    private final Service service;


    public Controller() {
        service = new Service();
    }

    public String interact(String src, Run run) {
        String result = "";

        reset();
        if (src.isEmpty()) {
            return result;
        }

        interpret(src);

        try {
            switch (cmd) {
                case LIST_INST -> {
                    var res = service.listInstruments(type);
                    result += res.toString();
                    if (res.size() > 50) {
                        result += "|..." + (res.size() - 50) + " record(s) not shown...\n";
                    }
                }
                case RENT -> {
                    service.rentInstrument(id1, id2);
                    result += String.format("Success, student (id = %s) rented instrument (id = %s)\n", id1, id2);
                }
                case LIST_LEASE -> {
                    var res = service.listLeases(id1);
                    result += res.toString();
                    if (res.size() > 50) {
                        result += "|..." + (res.size() - 50) + " record(s) not shown...\n";
                    }
                }
                case TERMINATE -> {
                    service.terminateRental(id1);
                    result += String.format("Success, rental (id = %s) is terminated as of tomorrow\n", id1);
                }
                case HELP -> result += help();
                case QUIT -> {
                    result += "Program shutting down...";
                    run.setRun(false);
                }
                case UNK_CMD -> result += reason;
            }
        } catch (DataAccessException e) {
            if (e.sqlState().equals("08006") || e.sqlState().equals("08003")) {
                result += "[ERROR] SQL State (" + e.sqlState() + ")\n";
            } else {
                result += "[Failed] " + e.getMessage() + "\n";
            }
            if (e.getCause() != null) {
                result += "Because " + e.getCause().getMessage() + "\n";
            }
        }
        return result;
    }

    private void interpret(String src) {
        String[] input = src.split(" ");

        try {
            cmd = Command.valueOf(input[0]);
        } catch (Exception e) {
            unknownCmd("[Invalid] \"" + input[0] + "\" Is An Unknown Command");
            return;
        }

        if (cmd == UNK_CMD) {
            unknownCmd("[Invalid] \"" + input[0] + "\" Is An Unknown Command");
            return;
        }

        switch (cmd) {
            case LIST_INST -> nullableTypeArg(input);
            case RENT -> twoIdArg(input);
            case LIST_LEASE -> nullableIdArg(input);
            case TERMINATE -> idArg(input);
            case HELP, QUIT -> cmdOnly(input);
        }
    }

    private String help() {
        return """
                                
                Command: LIST_INST
                Description: Lists all rentable instruments, can be filtered by instrument type
                Syntax: [LIST_INST (Instype)]
                    
                Command: RENT
                Description: Rents an instrument given a valid student and instrument ID
                Syntax: [RENT [StudentID] [InstrumentID]]
                  
                Command: LIST_LEASE
                Description: Lists all active leases, can be filtered by student ID
                Syntax: [LIST_LEASE (StudentID)]
                          
                Command: TERMINATE
                Description: Terminates an active rental given a valid lease ID
                Syntax: [TERMINATE [LeaseID]]
                        
                Command: HELP
                Description: Shows this help menu
                Syntax: [HELP]
                   
                Command: QUIT
                Description: Quits the program
                Syntax: [QUIT]
                                
                """;
    }


    private void nullableTypeArg(String[] input) {
        if (input.length > 2) {
            unknownCmd(String.format("[Invalid] Expected 0 To 1 Arguments Got %d", (input.length - 1)));
            return;
        }

        if (input.length == 1) {
            return;
        }

        try {
            type = Instype.valueOf(input[1].substring(0, 1).toUpperCase() + input[1].substring(1).toLowerCase());
        } catch (Exception e) {
            unknownCmd("[Invalid] Because Of Illegal Argument: " + input[1]);
        }
    }


    private void twoIdArg(String[] input) {
        String reason = "";

        if (input.length != 3) {
            unknownCmd(String.format("[Invalid] Expected 2 Arguments Got %d", (input.length - 1)));
            return;
        }

        try {
            id1 = Long.parseLong(input[1]);
            try {
                id2 = Long.parseLong(input[2]);

            } catch (Exception e) {
                reason = "[Invalid] Because Of Illegal (2nd) Argument: " + input[2];
                throw e;
            }
        } catch (Exception e) {
            if (reason.isEmpty()) {
                unknownCmd("[Invalid] Because Of Illegal (1st) Argument: " + input[1]);
            } else {
                unknownCmd(reason);
            }
        }
    }


    private void nullableIdArg(String[] input) {
        if (input.length > 2) {
            unknownCmd(String.format("[Invalid] Expected 0 To 1 Arguments Got %d", (input.length - 1)));
            return;
        }

        if (input.length == 1) {
            return;
        }

        try {
            id1 = Long.parseLong(input[1]);
        } catch (Exception e) {
            unknownCmd("[Invalid] Because Of Illegal Argument: " + input[1]);
        }
    }

    private void idArg(String[] input) {
        if (input.length != 2) {
            unknownCmd(String.format("[Invalid] Expected 1 Arguments Got %d", (input.length - 1)));
            return;
        }

        try {
            id1 = Long.parseLong(input[1]);
        } catch (Exception e) {
            unknownCmd("[Invalid] Because Of Illegal Argument: " + input[1]);
        }
    }

    private void cmdOnly(String[] input) {
        if (input.length > 1) {
            unknownCmd(String.format("[Invalid] Expected No Arguments Got %d", (input.length - 1)));
        }
    }

    private void reset() {
        cmd = null;
        type = null;
        id1 = null;
        id2 = null;
        reason = null;
    }

    private void unknownCmd(String reason) {
        cmd = UNK_CMD;
        this.reason = reason + "\n";
    }
}