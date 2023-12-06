
package project.model.Card;

import project.model.Board.Palace;

public abstract class Card {
    protected Palace palace;
    private String image;
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    /**<b>Constructor</b><p>
     * <b>Postcondition</b> Sets the palace type of the card
     *
     * @param palace  Card of Palace palace
     */
    protected Card(Palace palace){
        this.palace = palace;
    }
    
    /**<b>Observer:</b>
     * <b>Postcondition:</b> Checks if the card can be player over card c
     * @param c Card that we compare
     * @return  boolean
     */
    public abstract boolean matchCard(Card c);
    
    /** <b>Accessor</b>
     * <p><b>Postcondition:</b> Returns the palace card belongs to
     * @return the palace type 
     */
    public Palace getPalace(){
        return this.palace;
    }
   
    
    /**<b>Observer</b><p>
     * <b>Postcondition</b> Returns true  if the card is an instance of Special card
     *                      false if numbered card
     * @return True for special cards
     */
    public boolean isSpecial(){
        return false;
    }
    
     /**
     * <b>Accessor</b>
     * <p><b>Postcondition:</b> The string representation of a card is returned</p>
     * @return The string representation of a card 
     */
    @Override
    public abstract String toString();
    
}
