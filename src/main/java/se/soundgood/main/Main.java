package se.soundgood.main;


import se.soundgood.controller.Controller;
import se.soundgood.storage.SoundgoodDAO;

public class Main {
    public static void main(String... args) {
        Controller cont = new Controller();
        //cont.listInstruments();
        cont.rentInstrument(36L, 142L);
    }
}
