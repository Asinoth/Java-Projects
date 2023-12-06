package Model.Player;

import Model.Card.Card;
/**
 * This class represents a Player
 * 
 *
 */
public abstract class Player {
	protected String Name;
	protected int Money;
	protected int Loan;
	protected int Bills;
	protected int dice;
	protected int Position;
	protected int Month;
	protected boolean Finished;
	protected Card [] DC;
	protected int top_DC;
	protected Card [] BC;
	protected int top_BC;
	/**
	 * <b>Constructor</b>: Constructs a new Player with the given Name and Month and sets all the other variables <br />
	 * <b>post-condition</b>: Creates and initializes a Player with the given name and Month and also 
	 * initializes some other variables of a Player like his starting Money Loan and Bills, his dice and position,
	 * and all the Arrays needed for his Cards
	 * @param name the name of the Player
	 * @param Month the Months that he is going to play
	 */
	public Player(String Name , int Month){}

}
