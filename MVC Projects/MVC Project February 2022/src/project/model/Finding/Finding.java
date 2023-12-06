package project.model.Finding;

import project.model.Position.Position;

/**
 *Interface Finding acts as a connection between findings
 */
public interface Finding {
    
    public boolean isStatue();
    
    public String getImage();
    public void setImage(String image);
    public String getDescription();
    public void setDescription(String string);
    
}
