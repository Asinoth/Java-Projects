package csd.uoc.gr.A22;

public interface HomeSecurityADT 

{
	
								//There is also the default constructor which
								//doesnt need to be implemented by us
	
	public int condition(); 	//accessor
								//pre-conditions: The user has created a DoorSensor object
								// post-conditions: The user will get the current state of object
								// NoSensorException
	
	
	public void arm();			//transformer
								//pre-conditions: The user has created a DoorSensor object
								// post-conditions: The user will either arm the DoorSensor or get warned
								// NoSensorException
								//DoorsOpenException
	
	public void disarm();		//transformer
								//pre-conditions: The user has created a DoorSensor object
								// post-conditions: The user will disarm the DoorSensor or get prompted
								// NoSensorException
								//WrongPasswordException
			
	public void stay();			//transformer
								//pre-conditions: The user has created a DoorSensor object
								// post-conditions: The user will put the stay mode on or get prompted
								// NoSensorException
								//NotDisarmedException
								//DoorsOpenException

	
	public void change_pass();	//transformer
								//pre-conditions: The user has created a DoorSensor object
								// post-conditions: The user will change to a new password
								// NoSensorException
		}

