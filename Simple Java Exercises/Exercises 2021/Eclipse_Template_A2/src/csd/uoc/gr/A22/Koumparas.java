package csd.uoc.gr.A22;

abstract class Koumparas 


{ 
  // The currency it holds in a given time is represented by a number named value
  // The capacity of a given Koumpara is represented by a number named cap
  // The state of a given Koumpara is either broken or not broken, represented by a number named Isbroken
  // Currency that enters must always be positive
  // No matter the type of currency it always takes up at least 1 unit of space
  // There can be no capacity smaller than 1 or equal to infinity
  // There can be no Koumparas that is neither broken nor not broken
	


//////// Constructors ////////////	
//   Constructor:  Koumparas
//   Precondition:
//   a) cap > = 1
//   b) value >= 0
//   Postcondition
//	 Constructs a valid Koumparas instance with capacity cap and currency value
    public Koumparas(int cap, int value) {
	}
////////Accesors ////////////
// Method: break
// Precondition:
// Koumparas must not be broken and can only have two states
// Postcondition
// Returns the total value of money it holds
    public abstract int breakK();
/////// Observers///////////
// Method: isFull
// Precondition:
// Koumparas has a valid capacity
// Postcondition:
//	Returns 0 if Koumparas is not full yet
//  Returns 1 if Koumparas is full
	public abstract boolean isFull();
// Method: isBroken
// Precondition:
// Koumparas is either broken or not broken
// Postcondition:
// Returns 0 if Koumparas is broken
// Return 1 if Koumparas is not broken
	public abstract boolean isBroken();
/////// Transformers////////
// Method: addmoney
// Precondition:
// Currency that has value of 1 or greater
// Postcondition:
// The total value of Koumparas is raised by the amount, as well as the cap
	public abstract int addmoney(int money);

}


	class mine extends Koumparas
	{
		
		private int maxcap;
		private int curcap;
		private int total;
		private int isBroken;

		
		public mine(int cap, int value) {
			super(cap, value);
			this.curcap = cap;
			this.total = value;
		}

		@Override
		public int breakK() 
		{
			this.isBroken = 1;
			return this.total;
			
		}

		@Override
		public boolean isFull() 
		
		{
			if(this.curcap == this.maxcap)
				return true;
			else
				return false;
			
			
		}

		@Override
		public boolean isBroken() {
			
			if(this.isBroken == 1)
				return true;
			else 
				return false;
		}

		@Override
		public int addmoney(int money) 
		{
			this.total = this.total + money;
			return total;
			
		}
		
		
		public static void main(String[] args) 
		{
			mine Koumpara = new mine(5,0);
			System.out.println("Currently i got: " + Koumpara.total + " euro");
			Koumpara.addmoney(50);
			System.out.println("But i added some and now i got: " + Koumpara.total + " euro");
			if(Koumpara.isBroken() == false)
			System.out.println("For now i think my Koumpara is not yet broken" );
			if(Koumpara.isFull() == false);
			System.out.println("Neither is it full" );
			System.out.println("But i broken it anyway and i got my: " + Koumpara.breakK() + " euro" );
			if(Koumpara.isBroken() == true)
				System.out.println("Now think my Koumpara is broken" );
				if(Koumpara.isFull() == false);
				System.out.println("Although it never got full" );
			
		}
		
		
		
	}
