package csd.uoc.gr.model.position;

import csd.uoc.gr.controller.Controller;
import csd.uoc.gr.model.Player;

public class MailCardPosition extends CardPosition {
    final int cards;
    Controller main;

    public MailCardPosition(int cards, Controller main) {
        this.cards = cards;
        this.main = main;
    }

    @Override
    public void performAction(Player p) {
        this.main.gui.enableMailCards();
    }
}
