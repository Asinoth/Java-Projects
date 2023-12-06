/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model.Card;

import project.model.Board.Palace;


public class Minotaur extends SpecialCard {

    public Minotaur(Palace palace) {
        super(palace);
    }

  /**<b>Observer</b> 
  * <b>Postcondition</b> Card cannot be played if the pawn has reached checkpoint
  *                     card has no effect if the opponents pawn is theseus
  * @param c Card c to be played over 
  * @return True or false
  */
    @Override
    public boolean matchCard(Card c) {
        return false;
    }
    
    /**<b>Observer</b><p>
     * <b>Postcondition</b> Always returns true
     * 
     * @return  True always
     */
    @Override
    public boolean isMinotaur(){
        return true;
    }
    
    /**<b>Accessor</b>
     * <p><b>Postcondition</b> Returns the name of the card and the palace it 
     *                          belongs to
     * @return String name
     */
    @Override
    public String toString() {
        return "Minotaur of palace " + this.palace.name();
    }
}
