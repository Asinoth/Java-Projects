
package project.model.Board;

import project.model.Board.Palace;
import java.util.ArrayList;
import project.model.Card.*;
import project.model.Finding.*;
import project.model.Pawn.*;
import project.model.Position.FindingPosition;
import project.model.Position.Path;

/**
 * Player class describes the characteristics of a player and provides modification methods.
 */
public class Player {

    private final Card hand[];
    private final NumberedCard LastPlayed[];
    private ArrayList<Finding> Syllogi;
    private ArrayList<Finding> Fresco;
    private final Pawn pawns[];
    private int Score;
    private int NumOfStatues;

    public Player() {
        this.Syllogi = new ArrayList<>();
        this.Fresco = new ArrayList<>();
        this.Score = 0;
        this.NumOfStatues = 0;
        this.LastPlayed = new NumberedCard[4];
        this.hand = new Card[8];
        this.pawns = new Pawn[4];
        for (int i = 0; i < 3; i++) {
            pawns[i] = new Archeologist(this);
        }
        pawns[3] = new Theseus(this);

    }

    /** <b>Accessor(selector)</b>
     * <p>
     * <b>Postcondition:</b> Returns a new array of the available cards of the player
     *
     * @return the Cards collection of a player
     */
    public Card[] getCards() {
        return this.hand;
    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Precondition:</b>Card can be played over the previous card Card has to be contained in players hand(hand array)
     * <p>
     * <b>Postcondition:</b> Sets the card the player has chosen to play If NumberedCard
     *                      Updates LastCard array according to card's palace
     *
     * @param c *The card to be played
     */
    public void playCard(Card c) {
    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Precondition:</b>Player has available pawns and paths
     * <p>
     * <b>Postcondition:</b> Plays pawn on specified path && adds pawn to path
     *
     * @param p The pawn to be played
     * @param path The path to set pawn on
     */
    public void playPawn(Pawn p, Path path) {

    }

    /** <b>Transformer</b><p>
     * <b>Postcondition</b>Removes card c from hand
     *
     * @param c the card to be removed
     * @return the card
     */
    public Card discardCard(Card c) {
        return c;
    }

    /** <b>Accessor(selector)</b>
     * <p>
     * <b>Postcondition:</b> Returns last card played on each palace if no card has been played returns null
     *
     * @param palace indicates the palace needed
     * @return Last played card on palace path
     */
    public Card getLastCard(Palace palace) {
        return hand[0];
    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Precondition:</b> Player does not have 8 cards
     * <p>
     * <b>Postcondition:</b> Adds card c to players hand
     *
     * @param C Adds card c to player's hand
     */
    public void AddCard(Card C) {

    }

    /** <b>Transformer(mutative)</b>
     *
     * <p>
     * <b>Postcondition:</b> Increases numOfStatues of player by one and removes it from current position
     */
    private void AddStatue() {

    }

    /** <b>Observer</b><p>
     * <b>Postcondition</b> Returns true if the fresco is contained in players frescos else false
     *
     * @param fresco
     * @return Boolean true if the fresco has already been photographed else false
     */
    private boolean hasPhotographed(Fresco fresco) {
        return false;
    }

    /** <b>Transformer(mutative)</b>
     * <p>
     * <b>Precondition</b> The fresco has not beed photographed
     * <p>
     * <b>Postcondition:</b> Adds fresco to Fresco list without removing finding
     *
     * @param fresco The fresco to be added
     */
    private void photographFresco(Fresco fresco) {

    }

    /** <b>Transformer(mutative)</b>
     * <b>Postcondition:</b> Takes the rare finding from its posiition and adds it to Syllogi
     *
     * @param finding The finding to be added
     */
    private void addRareFinding(RareFinding finding) {

    }

    /** <b>Transformer</b>
     * <p>
     * <b>Precondition</b> Its the players turn
     * <p>
     * <b>Postcondition</b> Checks the type of the finding in position 
     *                          and calls the relevant method above
     *
     * @param pos Takes finding from position pos
     */
    public void takeFinding(FindingPosition pos) {
        //pos.getFinding();
    }

    /** <b>Transformer</b>
     * <p>
     * <b>Postcondition</b> Calculates the sum of pawn's positions rare findings values and frescos values and updates Scores
     *
     */
    private void updateScore() {

    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> Returns score
     *
     * @return The score that was calculated
     */
    public int getScore() {
        return 0;
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> Returns A pawn array of the pawns that have not been played
     *
     * @return Pawn array of the available pawns
     */
    public Pawn[] availablePawns() {
        return new Pawn[1];
    }

    /** <b>Accessor</b>
     * <p>
     * <b>Postcondition</b> Returns A path array of the path that the player has not put a pawn on
     *
     * @return Path array of the available paths
     */
    public Path[] unplayedPaths() {
        return new Path[1];
    }

}
