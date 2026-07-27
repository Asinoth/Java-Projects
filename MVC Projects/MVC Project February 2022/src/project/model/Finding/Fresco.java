package project.model.Finding;

public enum Fresco implements Finding {
    fresco1(20),
    fresco2(20),
    fresco3(15),
    fresco4(20),
    fresco5(15),
    fresco6(15);
    final private int value;
    private String description;
    private String Image;
    
    /** <b>Constructor</b>
     * <b>Postcondition</b> Initializes points and name of rare finding
     */
    private Fresco(int value) {
        this.value = value;
    }
/** <b>Accessor</b> Overridden method toString
     * <p>
     * <b>Postcondition</b> Returns a string of the name of the enum expression
     *
     * @return String name of enumeration
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

    /** <b>Observer</b><p>
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
