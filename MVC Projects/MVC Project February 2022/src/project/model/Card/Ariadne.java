/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model.Card;

import project.model.Board.Palace;

public class Ariadne extends SpecialCard {

    /**<b>Constructor</b><p>
     * <b>Postcondition:</b> Initializes palace variable for this card creates object
     * 
     * @param palace 
     */
    public Ariadne(Palace palace) {
        super(palace);
    }
    
    /**<b>Observer</b><p>
     * <b>Postcondition</b> Ariadne can be played over all the cards
     * @param c The card we want to attempt to play over this card
     * @return boolean
     */
    @Override
    public boolean matchCard(Card c) {
        return false;
    }

    /**<b>Observer</b><p>
     * <b>Postcondition</b> Returns true to check if this card is a type of ariadne
     *                      
     * @return boolean
     */
    @Override
    public boolean isAriadne() {
        return true;
    }

    /**<b>Accessor</b>
     * <p><b>Postcondition</b> Returns the name of the card and the palace it 
     *                          belongs to
     * @return String name
     */
    @Override
    public String toString() {
        return "Ariadne of palace "+ this.palace.name();
    }

}
