package mvc.model;

public class Character extends Card {
	String colour;
	boolean used;
	String belongs_to;
	//constructor for character cards
	
	public Character(String image, int value, String colour, boolean used, String belong) {
		super.setImage(image);
		super.setValue(value);
		this.setColour(colour);
		this.setuse(used);
		this.setplayer(belong);
		
	}
	
	
	// set the boolean of the card 
				//<b>Transformer:</b> sets the card's boolean
			     // <b>Postcondition:</b> card's boolean has been set
				public  void setuse(boolean used) {
				}
	
				
				//get the boolean of the card
		 //<b>Accessor:</b> returns the card's boolean
	   //   <b>Postcondition:</b> card's boolean has been returned
			public boolean getuse(){
				return used;};
			
				// set the colour of the card 
				//<b>Transformer:</b> sets the card's colour
			     // <b>Postcondition:</b> card's colour has been set
				public  void setColour(String colour) {
				}
	
				
				//get the colour of the card
		 //<b>Accessor:</b> returns the card's colour
	   //   <b>Postcondition:</b> card's colour has been returned
			public String getColour(){
				return colour;
				};
				
				
				// set the owner of the card 
				//<b>Transformer:</b> sets the card's owner
			     // <b>Postcondition:</b> card's owner has been set
				
				public  void setplayer(String belong) {
				}
	
				
				//get the owner of the card
		 //<b>Accessor:</b> returns the card's owner
	   //   <b>Postcondition:</b> card's owner has been returned
			public String getplayer(){
				return belongs_to;
				};
				
				// What the card activation does
				public void Action()
				{
					
				}
}