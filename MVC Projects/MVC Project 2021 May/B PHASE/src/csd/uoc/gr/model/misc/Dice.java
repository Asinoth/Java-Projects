package csd.uoc.gr.model.misc;

import java.util.Random;

public class Dice {
    Dice() {

    }

    static public int _throw() {
        Random universe = new Random();
        return universe.nextInt(6) + 1;
    }
}
