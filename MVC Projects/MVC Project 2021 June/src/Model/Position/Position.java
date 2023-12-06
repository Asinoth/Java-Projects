package Model.Position;

import Model.Player.Player;
/**
 * This is the interface of a Position that contains the methods signatures for every Position
 * 
 *
 */
public interface Position {
	/**
	 * <b>Observer</b>: Does what the position says 
	 * (the contents of this method change from the position that implements it) <br />
	 * <b>post-condition</b>: Does what the Position says          
	 * @param P1 for the Player who is in that Position 
	 * @param P2 for the other Player
	 */
	public void Perform_Action(Player P1 , Player P2);
}
