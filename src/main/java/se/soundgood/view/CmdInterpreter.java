package se.soundgood.view;

import se.soundgood.jooq.enums.Instype;

public class CmdInterpreter {

    private Command cmd = Command.UNK_CMD;
    private Long id1;
    private Long id2;
    private Instype type;
    private String reason;

    public Command getCmd() {
        return cmd;
    }

    public Long getId1() {
        return id1;
    }

    public Long getId2() {
        return id2;
    }

    public Instype getType() {
        return type;
    }

    public String getReason() {
        return reason;
    }

    public void interpret(String src) {
        reset();
        String[] input = src.split(" ");

        try {
            cmd = Command.valueOf(input[0]);
        } catch (Exception e) {
            unknownCmd("[Invalid] \"" + input[0] + "\" Is An Unknown Command");
            return;
        }

        if (cmd == Command.UNK_CMD) {
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
        cmd = Command.UNK_CMD;
        this.reason = reason;
    }
}