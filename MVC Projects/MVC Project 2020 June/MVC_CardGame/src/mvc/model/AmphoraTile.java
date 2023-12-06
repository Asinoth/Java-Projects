package mvc.model;

public class AmphoraTile extends FindingTile {
String colour;


	public AmphoraTile(int value, String image, int area, String colour) {
		super(value, image, area);
		this.setColour(colour);
		
	}
	// set the colour of the tile 
	//<b>Transformer:</b> sets the tile's colour
     // <b>Postcondition:</b> tile's colour has been set
	public  void setColour(String colour) {
	}

	
	//get the colour of the tile
//<b>Accessor:</b> returns the tile's colour
//   <b>Postcondition:</b> tile's colour has been returned
public String getColour(){
	return colour;
	};
}
