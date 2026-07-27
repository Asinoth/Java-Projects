package Model.Card;

import Model.Player.Player;
/**
 * This is the interface of a Card that contains the methods signatures for every card
 * 
 *
 */
public interface Card {
	/**
	 * <b>Observer</b>: Does what the card says and then moves the card to the pile or the player 
	 * (the contents of this method change from the card that implements it) <br />
	 * <b>post-condition</b>: Does what the card says and then moves the card to the pile or the player         
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public void get_card(Player P1 , Player P2);
}
