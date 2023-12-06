package csd.uoc.gr.model.position;

import csd.uoc.gr.controller.Controller;
import csd.uoc.gr.model.Player;

public class SpecialPosition extends Position {

    public enum SpecialPositionType {
        jackpot, sunday, thursday
    }

    ;
    final public SpecialPositionType type;
    Controller main;

    public SpecialPosition(SpecialPositionType type, Controller main) {
        this.type = type;
        this.main = main;
    }

    @Override
    public void performAction(Player p) {
        if (type == SpecialPositionType.jackpot) {
            p.setMoney(p.getMoney() + this.main.jackpot_money);
            this.main.jackpot_money = 0;
        } else if (type == SpecialPositionType.thursday) {

        } else if (type == SpecialPositionType.sunday) {

        }
    }
}
