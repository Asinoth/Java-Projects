package csd.uoc.gr.model.position;

import csd.uoc.gr.model.Player;

public class DicePosition extends Position {
    double money;
    int diceNumber;

    public double getMoney() {
        return money;
    }

    public int getDiceNumber() {
        return diceNumber;
    }

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public void performAction(Player p) {

    }
}
