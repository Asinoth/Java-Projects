package Model.Card;

import Model.Card.Card;
import Model.Player.Player;
/**
 * This class represents the Mail Card Charity
 * 
 *
 */
public abstract class Charity implements Card{
	protected String name;
	protected String message;
	private int Money_C;
	/**
	 * <b>Accessor</b>: Returns the money of the Charity Card <br />
	 * <b>post-condition</b>: Returns the money of the Charity Card 
	 * @return Money_C the Money of the Charity Card
	 */
	public abstract int get_Money_C();
	/**
	 * <b>Transformer</b>: Sets the Money of a Charity Card <br />
	 * <b>post-condition</b>; the Money_C of the Charity Card is changed to money_C
	 * @param money_C the new Money_C of the Charity Card
	 */
	public abstract void set_Money_C(int money_C);
	/**
	 * <b>Observer</b>: Takes the amount of Money(Money_C) from the Player P1 and gives it to the Jackpot 
	 * then moves the card to the pile <br />
	 * <b>post-condition</b>: The Money_C of the card is removed from the Money of the player P1 and gives it to the 
	 * Jackpot then moves the card to the pile
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Charity Card with the given name , Money_C and message <br />
	 * <b>post-condition</b>: Creates and initializes a Charity Card with the given name 
	 * , Money_C and message
	 * @param name the name of the Card
	 * @param Money_C the Money that the player has to give to the Jackpot
	 * @param message the message that the Charity Card contains
	 */
	public Charity (String name , int Money_C , String message){}

}
