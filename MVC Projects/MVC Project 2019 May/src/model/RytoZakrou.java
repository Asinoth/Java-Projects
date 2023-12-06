package model;
//creates basic information about Ryto zagrou
public class RytoZakrou extends Findings{
private static int value=25;
public static String name;
//set the type of the finding
	public RytoZakrou(){
		Kingdom type=Kingdom.ZAKROS;
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
public  String toString(){
	return name;}
}


