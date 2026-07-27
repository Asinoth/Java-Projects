package mvc.model;

public class SkeletonTile extends FindingTile {
boolean Big;
boolean Up;
//we only need 2 booleans to identify every skeleton

	public SkeletonTile(int value, String image, int area) {
		super(value, image, area);
		
		
	}
	// set the Big of the tile 
	//<b>Transformer:</b> sets the tile's Big
     // <b>Postcondition:</b> tile's Big has been set
	public  void setBig(boolean Big) {
	}

	
	//get the Big of the tile
//<b>Accessor:</b> returns the tile's Big
//   <b>Postcondition:</b> tile's Big has been returned
public boolean getBig(){
	return Big;
	};
	
	// set the Up of the tile 
	//<b>Transformer:</b> sets the tile's Up
     // <b>Postcondition:</b> tile's Up has been set
	public  void setUp(boolean Big) {
	}

	
	//get the Up of the tile
//<b>Accessor:</b> returns the tile's Up
//   <b>Postcondition:</b> tile's Upp has been returned
public boolean getUp(){
	return Big;
	};
}