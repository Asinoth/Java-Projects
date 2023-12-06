package project.model.Board;

import java.util.ArrayList;
import java.util.Collections;
import project.model.Card.Ariadne;
import project.model.Card.*;

public class Deck {
    private final ArrayList<Card> deck;
    /**<b>Constructor</b>
     * <b>Postcondition</b> Creates the deck and initializes it
     * 
     */
    public Deck(){
        this.deck = new ArrayList<>();
        initialize();
    }
    /** <b>Transformer</b>
     * <b>Postcondition</b>Initializes deck creating all the card to be used
     * 
     */
    private void initialize(){
        
        for (int i=1;i<11;i++){
            for(int j=0;j<2;j++){
                this.deck.add(new NumberedCard(Palace.Knossos,i));
                this.deck.add(new NumberedCard(Palace.Malia,i));
                this.deck.add(new NumberedCard(Palace.Phaistos,i));
                this.deck.add(new NumberedCard(Palace.Zakros,i));
            }
        }
        for(int j=0;j<3;j++){
            this.deck.add(new Ariadne(Palace.Malia));
            this.deck.add(new Ariadne(Palace.Knossos));
            this.deck.add(new Ariadne(Palace.Phaistos));
            this.deck.add(new Ariadne(Palace.Zakros));
        }
         for(int j=0;j<2;j++){
             this.deck.add(new Minotaur(Palace.Knossos));
             this.deck.add(new Minotaur(Palace.Malia));
             this.deck.add(new Minotaur(Palace.Phaistos));
             this.deck.add(new Minotaur(Palace.Zakros));
         }        
        
         shuffleDeck(); 
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Returns the array list with the deck
     * 
     * @return ArrayList the deck
     */
    public ArrayList getDeck(){
        return this.deck;
    }
    
    /**<b>Transformer</b><p>
     * <b>Postcondition</b> Deck shuffled
     */
    public void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    /**<b>Accessor && Transformer</b><p>
     * <b>Precondition</b> The deck must not be empty
     * <p><b>Postcondition</b> Draws card from deck and removes it from deck
     * 
     * @return First card from deck 
     */
    public Card drawCard(){
        Card c = deck.get(0);
        deck.remove(0);
        return c;
    }
    
    /**<b>Observer</b><p>
     * <b>Postcondition</b> If there are available cards returns false else returns true
     * 
     * @return true if the deck is empty
     */
    public boolean isEmpty(){
        return false;
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> The number of remaining cards in deck
     * 
     * @return Integer count of the remaining cards
     * 
     */
    public int availableCards(){
        return 0;
    }
    
}
