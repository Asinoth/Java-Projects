package csd.uoc.gr.A21;

import java.util.ArrayList;
import java.util.Arrays;

public class Drawing 

{

	private SolidShape[] arr =  new SolidShape [1000];
	private int activeCapacity = 0;
	
	
	
	
	
	public void set_activeCap(int number)
	{
		
		activeCapacity = number;
		
	}
	
	

	public int get_activeCap()
	{
		
		return activeCapacity;
		
	}
	
	
	public String toString(Drawing a)
	{

		String ret = "Number of shapes: " + activeCapacity + "\n";
		int sumEdge = 0,sumVert = 0,sumFace = 0,sumVol = 0;
	
		
		
		for (int i = 0; i<= activeCapacity; i++)
			{
			
			
			if(arr[i] == null)
				break;
			
			
			sumEdge+=arr[i].getNumberOfEdges();
			sumVert+=arr[i].getNumberOfVertices();
			sumFace+=arr[i].getNumberOfFaces();
			sumVol += arr[i].getVolume();
			System.out.println(" Array "+ i + " contains: " + a.arr[i].getVolume());
		
		
			
			
			}
		
		ret+= "Total faces: "+ sumFace + "\n";
		ret+= "Total vertices: "+ sumVert + "\n";
		ret+= "Total edges: "+ sumEdge + "\n";
		ret+= "Total volume: "+ sumVol + "\n";
		
		return ret;
		
		
	}
	
	
	
	
	
	public void set_arr()
	{
		SolidShape[] arr =  new SolidShape [1000];

		int activeCapacity = 0;
		
	}
	

	
	
	
	
	public void add(SolidShape s)
	{
		if(activeCapacity <= 999)
		{
			
			
			ArrayList<SolidShape> temp = new ArrayList<SolidShape>();
			temp.add(s);	
			arr[activeCapacity] = temp.get(0);
			activeCapacity++;
			
			
		}
		
		else
			System.out.println("Sorry, array is full");
	}
	

	
	
	
	
	
	
	
	
	public Drawing() 
	
	{
		set_arr();
		toString();
	}

	public static void main(String[] args) 
	
	{
	
		

	}

}
