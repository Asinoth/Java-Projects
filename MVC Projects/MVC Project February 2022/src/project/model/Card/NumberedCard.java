/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model.Card;
import project.model.Board.Palace;


public class NumberedCard extends Card {
    private final int value;

    public NumberedCard(Palace palace, int value) {
        super(palace);
        this.value = value;
    }
    
    /**<b>Accessor</b>
     * <b>Postcondition</b> Returns the value of numbered card
     * 
     * @return  the cards value
     */
    public int getValue(){
        return this.value;
    }
    
    /** <b>Observer</b>
     * <b>Postcondition</b> Returns true if the card c equal or more of the last 
     *                          numberedcard played and the game has yet to finish 
     * 
     * @param c Card we want to play
     * @return True if the card can be played else false
     */
    @Override
    public boolean matchCard(Card c) {
        return true;
    }

    /**<b>Observer</b>
     * <b>Postcondition</b> Returns false overrident super method
     * @return always false
     */
    @Override
    public boolean isSpecial() {
        return false;
    }

    /**<b>Accessor</b>
     * <p><b>Postcondition</b> Returns the name of the card and the palace it 
     *                          belongs to
     * @return String name
     */
    @Override
    public String toString() {
        return "NumberedCard of value "+this.getValue()+
               " of palace "+ ((Card)this).getPalace().toString();
    }
    
    
}
