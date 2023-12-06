/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import project.model.Position.Path;
import project.model.Card.Card;
import project.model.Finding.Fresco;
import project.model.Finding.RareFinding;
import project.model.Finding.SnakeGoddess;
import project.model.Position.FindingPosition;
import project.model.Position.Position;

/**
 *
 */
public class Board {

    private final Path paths[] = new Path[4];
    private ArrayList<Card> DiscardPile;

    /** <b>Constructor</b>
     * <p>
     * <b>Postcondition</b> Determines who plays firsts
     *                      Initializes paths
     *                      calls method initialize():
     *
     */
    public Board() {
        DiscardPile = new ArrayList<>();
        paths[0] = new Path(Palace.Knossos, RareFinding.RingOfMinoa);
        paths[1] = new Path(Palace.Malia, RareFinding.JewelOfMalia);
        paths[2] = new Path(Palace.Phaistos, RareFinding.DiskOfFaistos);
        paths[3] = new Path(Palace.Zakros, RareFinding.RhytonOfZakros);
        
        distributeFindings();
    }

    /**<b>Transformer</b>
     * <b>Postcondition</b> Puts all findings randomly in Finding positions
     *
     */
    private void distributeFindings() {
        
        ArrayList<Position> temp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 9; j = j + 2) {
                if (((FindingPosition) (paths[i].getPosition(j))).getFinding() == null) {
                    temp.add(paths[i].getPosition(j));
                }
            }
            if (((FindingPosition) (paths[i].getPosition(9))).getFinding() == null) {
                temp.add(paths[i].getPosition(9));
            }
        }
        Collections.shuffle(temp);
        for (int i = 0; i < 10; i++) {
            ((FindingPosition) (temp.get(i))).setFinding(new SnakeGoddess());
        }
        for (int i = 10; i < 16; i++) {
            ((FindingPosition) (temp.get(i))).setFinding(Fresco.valueOf("fresco" + (i - 9)));
        }


    }


    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Calculates from the player's pawns how many checkpoints have been reached
     *
     * @return integer the total checkpoints reached by player1 and player2 pawns
     */
    public int checkPointsReached() {
        return 0;
    }


    /** <b>Transformer</b>
     * <p>
     * <b>Postcondition</b> Moves card c to discardpile
     *
     * @param c the card to be discarded
     */
    public void discardCard(Card c) {

    }
}
