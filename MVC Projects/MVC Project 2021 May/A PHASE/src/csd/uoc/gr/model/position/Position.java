package csd.uoc.gr.model.position;

import csd.uoc.gr.model.Player;
import csd.uoc.gr.model.misc.Day;

public abstract class Position {
    public abstract void performAction(Player p);
    int table_number;
    Day day;

    public Day getDay() {
        return day;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public void setDay(Day day) {
        this.day = day;
    }

}
