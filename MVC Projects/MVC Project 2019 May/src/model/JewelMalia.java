package model;
//Creates the basic information about malia 
public class JewelMalia extends Findings{
private static int value=25;
public static String name;

//set the type of the finding
	public JewelMalia(){
		Kingdom type=Kingdom.MALIA;
	}
	//sets the number of the position in the path
public void Setposition(){}
//return the number of the path
//pre condition number not null 
public int retPosition(){
	return 0;}
//return if the Godness has found
	public boolean Isfound(){
		return false;}
	//return the name 
	//post condition return string
	public  String toString(){
		return name;}
	}
