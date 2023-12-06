
package project.model.Board;

/**
 *Enumeration Palace consists of the 4 palaces of the game
 */
public enum Palace {
    Knossos,Malia,Phaistos,Zakros;
    
    /**<b>Accessor</b>
     * <b>Postcondition</b> Returns the name of this enum constant, 
     *                      exactly as declared in its enum declaration.
     * @return the string name of the enum 
     */
    @Override
    public String toString(){
        return this.name();
    }
}
