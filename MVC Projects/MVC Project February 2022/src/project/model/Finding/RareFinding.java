package project.model.Finding;

/**
 * Enum class of the 4 rare Findings to be placed in one of each paths
 *
 */
public enum RareFinding implements Finding {
    DiskOfFaistos(35),
    RingOfMinoa(25),
    JewelOfMalia(25),
    RhytonOfZakros(25);

    final private int value;
    private String description;
    private String Image;
    
    /** <b>Constructor</b>
     * <b>Postcondition</b> Initializes points and name of rare finding
     */
    private RareFinding(int value) {
        this.value = value;
    }

    /** <b>Accessor</b> Overriden method toString
     * <p>
     * <b>Postcondition</b> Returns a string of the name of the enum expression
     *
     * @return String name of enum
     */
    @Override
    public String toString() {
        return this.name();
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Returns the points value of the Finding
     *
     * @return Integer of the value of the enum
     */
    public int getValue() {
        return value;
    }

    /**<b>Observer</b><p>
     * <b>Postcondition</b> Returns false
     * 
     * @return false
     */
    @Override
    public boolean isStatue() {
        return false;
    }
    
    /**
     * Methods for the graphic interface
     * @return String
     */
    @Override
    public String getImage() {
        return "";
    }

    @Override
    public void setImage(String image) {
    }

    @Override
    public String getDescription() {
        return"";
    }

    @Override
    public void setDescription(String string) {
    }


}
