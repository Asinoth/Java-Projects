/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import project.model.Board.Palace;
import project.model.Board.Player;
import project.model.Card.Card;
import project.model.Pawn.Pawn;
import project.model.Position.Position;

/**
 *
 * 
 */
public class View extends JFrame {

    JMenu menu;
    JLayeredPane pane1, pane2, mainpane;
    JButton Deck, Frescos1, Frescos2;
    JButton Cards1[], Cards2[];//8 for each
    JLabel Info, pawns1[], pawns2[], availablePawns1[],
            availablePawns2[], Score1, Score2, Statues1, Statues2;
    JLabel path1[], path2[], path3[], path4[];
    JLabel RareFinding1[], RareFinding2[];

    /**
     * <b>transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p>
     * <b>Postcondition:</b> initializes some buttons and labels </p>
     *
     */
    private void initComponents() {

    }


    /**<b>Transformer</b>
     * <p>
     * <b>Postcondition</b> Updates the cards of player in display
     *
     * @param player
     */
    public void updatePlayersCards(Player player) {
        player.getCards();
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates last cards of player
     *(gets player last card pile array)
     * @param player 's cards
     */
    public void updateLastCardPile(Player player) {
            player.getLastCard(Palace.Malia);
    }

    /**<b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates position of pawn in display
     * @param pawn 
     */
    public void updatePawn(Pawn pawn){
        
    }
    
    /**<b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates components of player display
     * @param player 
     */
     public void updateDisplay(Player player){
         
     }
    
    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Updates Discard Pile of player
     *
     * @param player the player
     */
    public void updateDiscardPile(Player player) {

    }

}
