package model;
//Creates the basic information about Faistos disk
public class DiskosFaistou extends Findings {
	public static int value=35;
	public static String name;
	
	//constractor set the type of the finding
	public DiskosFaistou(){
		Kingdom type=Kingdom.PHAISTOS;
	}
	//sets the number of the position in the path
public void Setposition(){}

//post conditionreturn the number of the path
//pre condition number not null 
public int retPosition(){
	return 0;}
//return if the finding  has found
//post condition return boolean 
	public boolean Isfound(){
		return false;}
//return the name of the finding 
	//post condition returtn string
public  String toString(){
	return name;}
}


