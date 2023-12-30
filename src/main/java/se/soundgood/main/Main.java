package se.soundgood.main;

import org.jooq.exception.DataAccessException;
import se.soundgood.controller.Controller;
import se.soundgood.view.View;

import java.io.IOException;

public class Main {
    public static void main(String... args) {
        try {
            View view = new View(new Controller());
            view.Menu();
        } catch (/*SQLTransactionRollbackException |*/ DataAccessException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


//cont.listInstruments(Instype.valueOf("Guitar"));
//cont.rentInstrument(36L, 142L);
//cont.terminateRental(45L);
//cont.listLeases(34L);