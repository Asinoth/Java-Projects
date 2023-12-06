package csd.uoc.gr.A21;

class TESTER 
{
	
	
	
	public static void main(String[] args)
	{

		System.out.println(new SolidShape(2,1,5.12));
		System.out.println(new Sphere(2,1,5.12,10));
		System.out.println(new Cylinder(2,1,5.12,6.7,8.7));
		System.out.println(new Cube(2,1,5.12, 6.5));
		
	
		
		Drawing mine = new Drawing();
		Sphere[] spheres =  new Sphere [50];
		for(int j = 0; j <= 49; j++)
		{
			spheres[j] = new Sphere(0,0,0,j+1);

			mine.add(spheres[j]);
			
		}
		
	
		String res = mine.toString(mine);
		System.out.println(res);
		
		
		
		
		Drawing sec = new Drawing();
		Sphere[] spheres2 =  new Sphere [25];
		Cube[] cubes = new Cube[25];
		for(int j = 0; j <= 24; j++)
		{
			if(j == 0)
			{
				cubes[0] = new Cube(0,0,0,1);
				cubes[0].setNumberOfEdges(12);
				cubes[0].setNumberOfVertices(8);
				cubes[0].setNumberOfFaces(6);
				spheres2[0] = new Sphere(0,0,0,1);
				sec.add(spheres[j]);
				sec.add(cubes[j]);
				
			}
			
			else
			{
			
				double s1 = spheres2[j-1].get_rad() / (cubes[j-1].get_side()); //ακτίνα σφαίρας / πλευρά κύβου
				
				spheres2[j] = new Sphere(0,0,0,s1);							   // και φτιάχνω τα νέα object
				cubes[j] = new Cube(0,0,0,s1);
				cubes[j].setNumberOfEdges(12);
				cubes[j].setNumberOfVertices(8);
				cubes[j].setNumberOfFaces(6);
				
				sec.add(spheres[j]);
				sec.add(cubes[j]);
			}
			
		}
		
		
		String res2 = sec.toString(sec);									//δεν βγαίνει 4114874, λογικά αριθμητικό
																			// στην πάνω υλοποίηση
		System.out.println(res2);
		
		
	
	}
	
}