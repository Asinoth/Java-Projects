package project.model.Finding;

/**
 * Represents a finding of statue
 * 
 */
public class SnakeGoddess implements Finding {
    private String description;
    private String Image;
    
    /**<b>Observer</b><p>
     * <b>Postcondition</b> Returns true
     * 
     * @return always true
     */
    @Override
    public boolean isStatue() {
        return true;
    }

    /**<b>Accessor</b><p>
     * <b>Postcondition </b> Returns SnakeGoddess
     * 
     * @return "SnakeGoddess"
     */
     @Override
    public String toString(){
        return "SnakeGoddess";
    }
    
    /**
     * Methods for graphic interface
     * @return String of image
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
        return "";
    }

    @Override
    public void setDescription(String string) {
    }
    
   
    
}
