package Model.Card;

import Model.Card.Card;
import Model.Player.Player;
/**
 * This class represents the Mail Card Pay the Neighbor
 * 
 *
 */
public abstract class Pay_The_Neighdor implements Card{
	protected String name;
	private int Money_C;
	protected String message;
	/**
	 * <b>Accessor</b>: Returns the money of the Pay_The_Neighdor Card  <br />
	 * <b>post-condition</b>: Returns the money of the Pay_The_Neighdor Card 
	 * @return Money_C the Money of the Pay_The_Neighdor Card
	 */
	public abstract int get_Money_C();
	/**
	 * <b>Transformer</b>: Sets the Money of a Pay_The_Neighdor Card <br />
	 * <b>post-condition</b>; the Money_C of the Pay_The_Neighdor Card is changed to money_C
	 * @param money_C the new Money_C of the Pay_The_Neighdor Card
	 */
	public abstract void set_Money_C(int money_C);
	/**
	 * <b>Observer</b>: Charges the player P1 with an amount of money(Money_C)and gives it to the Player 2
	 * ,then moves the card to the pile <br />
	 * <b>post-condition</b>: The Money_C of the card is removed to the Money of the player P1 and added to 
	 * the Money of the Player P2, then the card moves to the pile
	 * @param P1 for the Player who takes the card 
	 * @param P2 for the other Player
	 */
	public abstract void get_card(Player P1 , Player P2);
	/**
	 * <b>Constructor</b>: Constructs a new Pay_The_Neighdor Card with the given name , Money_C and message <br />
	 * <b>post-condition</b>: Creates and initializes a Pay_The_Neighdor Card with the given name 
	 * , Money_C and message
	 * @param name the name of the Card
	 * @param Money_C the Money that the player has to pay
	 * @param message the message that the Pay_The_Neighdor Card contains
	 */
	public Pay_The_Neighdor (String name , int Money_C , String message) {}
	
}
