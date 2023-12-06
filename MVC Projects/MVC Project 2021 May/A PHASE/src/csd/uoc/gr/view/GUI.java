package csd.uoc.gr.view;

import csd.uoc.gr.model.Player;
import csd.uoc.gr.model.card.Card;

import javax.swing.*;

public class GUI extends JFrame{
    public GUI(){
        this.main = new JPanel();
    }
    JPanel main;
    JLayeredPane[] table;
    JButton dealCards_button;
    JButton mailCards_button;
    JButton p1_get_loan;
    JButton p1_dice_button;
    JButton p1_end_turn;
    JButton p1_my_deal_cards;
    JButton p2_get_loan;
    JButton p2_dice_button;
    JButton p2_end_turn;
    JButton p2_my_deal_cards;

    /**
     * Updates the dice's icon
     * @param num = new dice throw
     */
    public void setDice(int num){

    }

    /**
     * Used by the controller to change the behaviour of buttons
     * for the previous player and activate the button for the active player
     */
    public void changeActivePlayerGUI(){

    }

    /**
     * Used by controller for card activation through dialog
     */
    public void useCard(Card c){
        PaydayDialog dialog = new PaydayDialog();
    }

    /**
     * Updates the player's pawn position
     * @param num new position of the player's pawn
     */
    public void setPlayerPosition(Player p, int num){

    }

    /**
     * Initialized evey button with its corresponding icon
     */
    void initButtons(){

    }

    /**
     * Redraws every graphical component
     */
    public void update(){

    }

}
