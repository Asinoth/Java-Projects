
package project.model.Position;

import project.model.Finding.Finding;
import project.model.Pawn.Pawn;

/**
 *Class that represents a position in the path
 *  pos1(-20),pos2(-15),pos3(-10),pos4(5),pos5(10),pos6(15),pos7(30),pos8(35),pos9(50)
 */
public abstract class Position {
    private final int points;
    private final int posnumber; //position number in path
    private final Path path;
    

    /**<b>Constructor</b>
     * <b>Postcondition</b> Initializes the points of the current position
     * 
     * @param points the points of the position
     */
    protected Position(int points,Path path,int positionInPath){
        this.points = points;
        this.path = path;
        this.posnumber = positionInPath;
    }
   
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Return the points specified in this position
     * (to be used from pawn class)
     * @return Integer of points
    */
    public int getPoints(){
        return this.points;
    }
    
    /**<b>Accessor</b><p>
     * <b>Postcondition</b> Returns the path this position belongs to
     * 
     * @return The path this position is in
     */
    public Path getPath(){
        return this.path;
    }
  
    /**<b>Observer</b><p>
     * <b>Postcondition</b> FindingPosition: TakeFinding
     *                    SimplePosition: Nothing
     * 
     */
    public abstract void availableMoves();
}
