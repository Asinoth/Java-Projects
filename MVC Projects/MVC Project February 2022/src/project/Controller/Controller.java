package project.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import project.model.Board.Board;
import project.model.Board.Deck;
import project.model.Board.Player;
import project.view.View;

/**
 * Controller is the master of the game and controls all of the operations executed
 */
public class Controller {

    private final Player player1, player2;
    private final Board board;
    private final Deck deck;
    View view;
    private boolean turn; // Determines who plays  - At the end of each round it changes

    public Controller() {

        turn = (new Random()).nextBoolean();
        this.deck = new Deck();
        board = new Board();
        player1 = new Player();
        player2 = new Player();
        view = new View();
        init_player_cards();
    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Postcondition:</b> initializes players cards in the beginning </p>
     */
    private void init_player_cards() {
        for (int i = 0; i < 8; i++) {
            player1.AddCard(deck.drawCard());
            player2.AddCard(deck.drawCard());
        }

    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Determines whose turn it is
     *
     * @return player1 or player2
     */
    public Player getTurn() {
        if (this.turn) {
            return player1; //as in player 1
        } else {
            return player2; //as in player 2
        }
    }

    /**<b>Transformer</b>
     * <b>Postcondition</b> Switches turn
     * 
     */
    public void endTurn(){
        turn = !turn; 
    }
    
    /** <b>Observer</b><p>
     * <b>Postcondition</b> True if 4 checkpoints have been reached or the deck has been emptied
     *
     * @return boolean true if the game has ended
     */
    public boolean isFinished() {
        return false;
    }

    /** <b>Accessor</b><p>
     * <b>Precondition</b> The game has finished
     * <b>Postcondition</b> Returns the winner
     *
     * @return The winner
     *
     */
    public Player getWinner() {
        return player1;
    }

    /* Listeners work only on players turn*/
    
    /**<b>transformer(mutative)</b>
     * <p><b>Postcondition</b> Actions for player1 
     *
     */
    private class Player1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Actions for player2 cards
     */
    private class Player2Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Draws card from deck
     */
    private class DeckListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Draws card from deck
     *
     */
    private class FrescoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    /** <b>transformer(mutative)</b>
     * <p>
     * <b>Postcondition</b> Hover of button provides info about the finding
     */
    private class FindingInfoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }

    }
}
