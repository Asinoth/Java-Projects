/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model.Card;

import project.model.Board.Palace;


public abstract class SpecialCard extends Card {
    
    /**<b>Constructor</b><p>
     * <b>PostCondition</b> Creates a Special card with type of Palace palace
     * 
     * @param palace The palace the card belongs to
     */
    public SpecialCard(Palace palace) {
        super(palace);
    }
    
    /**<b>Observer</b>
     * <b>Postcondition</b> Overriding method returns true
     * 
     * @return always true
     */
    @Override
    public boolean isSpecial(){
        return true;
    }
     
    /**<b>Observer</b>
     * <b>Postcondition</b> Returns false unless overriden
     * 
     * @return Returns false unless overriden
     */
    public boolean isMinotaur(){
        return false;
    }
    
   /**<b>Observer</b>
     * <b>Postcondition</b> Returns false unless overridden
     * 
     * @return Returns false unless overridden
     */
    public boolean isAriadne(){
        return false;
    }
    
}
