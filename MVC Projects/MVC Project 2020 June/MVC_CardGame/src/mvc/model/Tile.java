package mvc.model;

public abstract class Tile {
    int value;
    String image;
    int area;
    
    
  //get the image of the tile
  	 //<b>Accessor:</b> returns the tile's image
     //   <b>Postcondition:</b> tile's image has been returned
    public String getImage() {
        return image;
    }
    
    
 // set the image of the tile 
 		//<b>Transformer:</b> sets the tile's image
 	     // <b>Postcondition:</b> tile's image has been set
    public void setImage(String image) {
        this.image = image;
    }

  //get the number of the tile
  	 //<b>Accessor:</b> returns the tile's value
     //   <b>Postcondition:</b> tile's value has been returned
    public int getValue() {
        return value;
    }
    
    
 // set the number of the tile 
 		//<b>Transformer:</b> sets the tile's value
 	     // <b>Postcondition:</b> tile's value has been set
    public void setValue(int value) {
        this.value = value;
    }
    
    
  //get the area number of the tile
 	 //<b>Accessor:</b> returns the tile's area number
    //   <b>Postcondition:</b> tile's area number has been returned
   public int getArea() {
       return value;
   }
   
   
// set the area number of the tile 
		//<b>Transformer:</b> sets the tile's area number
	     // <b>Postcondition:</b> tile's area number has been set
   public void setArea(int value) {
       this.value = value;
   }


  
}