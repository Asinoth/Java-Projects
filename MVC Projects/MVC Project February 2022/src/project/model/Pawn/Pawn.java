
package project.model.Pawn;

import project.model.Board.Player;
import project.model.Position.*;
/**
 * Represents a pawn object
 */
public abstract class Pawn {

    private Position position;
    private Path path;
    private final Player player;

    //method get score returns doyble for theseus
    protected Pawn(Player player) {
        this.player = player;
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Returns the points of the position the pawn is on
     *                      if position is null return 0;
     *
     * @return the points of the position
     */
    public int getPositionScore() {
        return 0;
    }

    /** <b>Transformer</b><p>
     * <b>Postcondition:</b> Sets the path the pawn is on 
     *
     * @param path The path to be initialized to
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Gets the path the pawn is set on
     *
     * @return the path
     */
    public Path getPath() {
        return this.path;
    }

    /** <b>Transformer</b><p>
     * <b>Postcondition:</b> Sets the pawns position
     *
     * @param pos The position to be set to
     */
    public void setPosition(Position pos) {
        this.position = pos;
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Returns the position of the pawn
     *
     * @return Position of the pawn
     */
    public Position getPosition() {
        return this.position;
    }

    /** <b>Observer</b>
     * <p>
     * <b>Postcondition</b> Checks if the pawn is theseus
     *
     * @return true if the pawn is instance of theseus false if its archeologist
     */
    public boolean isTheseus() {
        return false;
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition:</b> Returns the owner of the pawn
     *
     * @return The owner of the pawn
     */
    public Player getPlayer() {
        return this.player;
    }

    /** <b>Transformer</b><p>
     * <b>Postcondition</b> Sets the owner of the pawn
     *
     * @param player The player to be set as owner
     *
     * public void setPlayer(Player player){ this.player= player; }
     */
    
    /** <b>Transformer</b><p>
     * <b>Precondition:</b><p>
     * The pawn is not in the last place
     * <b>Postcondition:</b> Advances pawn by one 
     *
     */
    public void advancebyOne() {

    }

    /** <b>Transformer</b><p>
     * <b>Precondition:</b><p>
     * The pawn is not in the first place
     * <b>Postcondition:</b> Returns pawn by one place back if it passes checkpoint sets checkpoint to false
     *
     */
    public void gobackbyOne() {

    }

    /** <b>Observer</b><p>
     * <b>Precondition</b> The pawn has started a path
     * <b>Postcondition </b> True if the pawn has passed position 7 false otherwise
     * @return boolean true if pawn passed position 7
     */
    public boolean reachedCheckPoint() {
        return false;
    }
    

}
