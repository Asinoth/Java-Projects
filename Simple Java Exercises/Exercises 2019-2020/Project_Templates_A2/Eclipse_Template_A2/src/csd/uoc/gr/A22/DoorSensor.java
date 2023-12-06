package csd.uoc.gr.A22;

import java.util.Scanner;
import org.jfugue.*;

public class DoorSensor implements HomeSecurityADT


{
	
	
private boolean open = true;
private int pass = 1111;
private int cont = 0;
private static Player p = new Player();




public boolean isOpen() { return open;}

public int get_pass()
{
	return this.pass;
}


public void setOpen(boolean status) 


{ open=status;}




public static void main(String[] args) 
{
	p.play("[80]");
	DoorSensor mine = new DoorSensor();
	System.out.println("Doors are: "+ mine.open);
	System.out.println("Password is: "+ mine.pass);
	System.out.println("Alarm Condition is: "+ mine.condition());
	mine.setOpen(false);
	mine.arm();
	System.out.println("Doors are: "+ mine.open);
	System.out.println("Password is: "+ mine.pass);
	System.out.println("Alarm Condition is: "+ mine.condition());
	mine.disarm();
	mine.change_pass();
	System.out.println("Doors are: "+ mine.open);
	System.out.println("Password is: "+ mine.pass);
	System.out.println("Alarm Condition is: "+ mine.condition());
	mine.disarm();
	System.out.println("Doors are: "+ mine.open);
	System.out.println("Password is: "+ mine.pass);
	System.out.println("Alarm Condition is: "+ mine.condition());
	mine.stay();
	
}




public int condition() 
{
	return cont;
}



public void arm() 
{
	if(this.isOpen() == true)
		System.out.println("Please close the doors first...");
	else
		{
		this.cont = 1;
		this.setOpen(false);
		p.play("[80]");
		}
	
}




public void disarm() 
{
	System.out.println("Please enter password: ");
	Scanner sc = new Scanner(System.in);
	
	if( sc.nextInt() == this.pass)
	{
		System.out.println("Deactivating alarm... ");
		this.cont = 3;
		p.play("[80]");
		
	}
	
	else
		System.out.println("Wrong Password... ");
	
}




public void stay() 
{
	if(this.isOpen() == false && this.cont == 3)
	{
		this.cont = 2;
		p.play("C D E F G A B");
		
	}
	else
		System.out.println("Either a door is open or alarm NOT disarmed...");
}





public void change_pass() 
{
	System.out.println("Please enter new password: ");
	Scanner sc = new Scanner(System.in);
	 this.pass = sc.nextInt();
	
}




}




