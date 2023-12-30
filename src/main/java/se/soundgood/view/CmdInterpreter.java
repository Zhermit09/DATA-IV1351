package se.soundgood.view;

import se.soundgood.jooq.enums.Instype;

public class CmdInterpreter {

    private Command cmd = Command.UNK_CMD;
    private Long id1;
    private Long id2;
    private Instype type;

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

    public void interpret(String src) {
        String[] input = src.split(" ");

        if (input.length > 3) {
            unkownCmd();
            return;
        }

        try {
            cmd = Command.valueOf(input[0]);
        } catch (Exception e) {
            unkownCmd();
            return;
        }

        switch (cmd) {
            case LIST_INST -> nullableTypeParam(input);
            case RENT -> twoIdParam(input);
            case LIST_LEASE -> nullableIdParam(input);
            case TERMINATE -> idParam(input);
            case HELP, QUIT -> cmdOnly(input);
        }
    }


    private void nullableTypeParam(String[] input) {
        if (input.length > 2) {
            unkownCmd();
            return;
        }

        if (input.length == 1) {
            nullParam(input);
        }

        try {
            type = Instype.valueOf(input[1]);
            id1 = null;
            id2 = null;
        } catch (Exception e) {
            unkownCmd();
        }
    }


    private void twoIdParam(String[] input) {
        type = null;
        try {
            id1 = Long.parseLong(input[1]);
            try {
                id2 = Long.parseLong(input[2]);

            } catch (Exception e) {
                unkownCmd();
            }
        } catch (Exception e) {
            unkownCmd();
        }
    }


    private void nullableIdParam(String[] input) {
        if (input.length > 2) {
            unkownCmd();
            return;
        }

        if (input.length == 1) {
            nullParam(input);
        }

        try {
            type = null;
            id1 = Long.parseLong(input[1]);
            id2 = null;
        } catch (Exception e) {
            unkownCmd();
        }
    }

    private void idParam(String[] input) {
        if (input.length > 2) {
            unkownCmd();
            return;
        }

        try {
            type = null;
            id1 = Long.parseLong(input[1]);
            id2 = null;
        } catch (Exception e) {
            unkownCmd();
        }
    }

    private void cmdOnly(String[] input) {
        if (input.length > 1) {
            unkownCmd();
        }
    }

    private void nullParam(String[] input) {
        type = null;
        id1 = null;
        id2 = null;
    }

    private void unkownCmd() {
        cmd = Command.UNK_CMD;
        id1 = null;
        id2 = null;
        type = null;
    }
}
