package mvc.model;

public class SphinxTile extends StatueTile 

{
	
	public SphinxTile(int value, String image, int area, String type) {
		super(value, image, area);	
		this.setType(type);
	}	
	
	// set the type of the tile 
	//<b>Transformer:</b> sets the tile's type
     // <b>Postcondition:</b> tile's type has been set
	public  void setType(String type) {
	}

	
	//get the type of the tile
//<b>Accessor:</b> returns the tile's type
//   <b>Postcondition:</b> tile's type has been returned
public String getType(){
	return type;
	};
	
	
}