package Model.Player;
/**
 * This class represents the Jackpot
 * 
 *
 */
public abstract class Jackpot {
	protected int Jackpot;
	/**
	 * <b>Observer</b>: Gives the player P1 the Jackpot <br />
	 * <b>post-condition</b>: Adds the Jackpot to the Money of the Player P1 and then makes Jackpot 0 
	 * @param P1 the Player that plays this turn
	 */
	public abstract void win_Jackpot(Player P1);
	/**
	 * <b>Observer</b>: Adds the amount of Money(j) to the Jackpot <br />
	 * <b>post-condition</b>: Removes the amount of Money(j) from the Money of the Player P1 
	 * and then puts it to the Jackpot
	 * @param P1 the Player that plays this turn
	 * @param j the amount of Money that goes to the Jackpot
	 */
	public abstract void add_Jackpot(Player P1 , int j);
	/**
	 * <b>Constructor</b>: Constructs a new Jackpot and sets it to 0 <br />
	 * <b>post-condition</b>: Creates and initializes a Jackpot and sets the Jackpot to 0
	 */
	public Jackpot(){}
}
