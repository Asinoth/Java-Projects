package csd.uoc.gr.A22;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoorSensorTest {

	@Test
	public void testIsOpen() {
		DoorSensor mine = new DoorSensor();
		assertTrue(mine.isOpen());
		System.out.println("TEST1 PASS");
	}

	@Test
	public void testSetOpen() {
		DoorSensor mine = new DoorSensor();
		mine.setOpen(false);
		assertFalse(mine.isOpen());
		System.out.println("TEST2 PASS");
	}

	@Test
	public void testCondition() {
		DoorSensor mine = new DoorSensor();
		assertEquals(0, mine.condition());
		System.out.println("TEST3 PASS");
	}

	@Test
	public void testArm() {
		DoorSensor mine = new DoorSensor();
		mine.setOpen(false);
		mine.arm();
		assertEquals(1, mine.condition());
		System.out.println("TEST4 PASS");
	}

	@Test
	public void testDisarm() {
		DoorSensor mine = new DoorSensor();
		mine.disarm();
		assertEquals(3, mine.condition());
		System.out.println("TEST5 PASS");
	}

	@Test
	public void testStay() {
		DoorSensor mine = new DoorSensor();
		mine.setOpen(false);
		mine.disarm();
		mine.stay();
		assertEquals(2, mine.condition());
		System.out.println("TEST6 PASS");
	}

	@Test
	public void testChange_pass() {
		DoorSensor mine = new DoorSensor();
		int temp = mine.get_pass();
		mine.change_pass();
		assertNotEquals(temp,mine.get_pass());
		System.out.println("TEST7 PASS");
	}

}
