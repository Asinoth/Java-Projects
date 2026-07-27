package csd.uoc.gr.model.position;

import csd.uoc.gr.controller.Controller;
import csd.uoc.gr.model.Player;

public class DealCardPosition extends CardPosition {
    public enum SpecialPositionType {
        buyer, deal
    }

    ;
    final public SpecialPositionType type;
    Controller main;

    public DealCardPosition(SpecialPositionType type, Controller main) {
        this.type = type;
        this.main = main;
    }

    @Override
    public void performAction(Player p) {
        if (this.type == SpecialPositionType.deal)
            this.main.gui.enableDealCards();
    }
}
