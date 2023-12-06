/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model;

/**
 *
 *
 */
public  class Card {
    int value;
    String image;
    
  //get the image of the card
  	 //<b>Accessor:</b> returns the card's image
     //   <b>Postcondition:</b> card's image has been returned
    public String getImage() {
        return image;
    }
 // set the image of the card 
 		//<b>Transformer:</b> sets the card's image
 	     // <b>Postcondition:</b> card's image has been set
    public void setImage(String image) {
        this.image = image;
    }

  //get the number of the card
  	 //<b>Accessor:</b> returns the card's value
     //   <b>Postcondition:</b> card's value has been returned
    public int getValue() {
        return value;
    }
 // set the number of the card 
 		//<b>Transformer:</b> sets the card's value
 	     // <b>Postcondition:</b> card's value has been set
    public void setValue(int value) {
        this.value = value;
    }


  
}
