package com.example.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator sut;
	private HelpMethods hm;

	@Before
	public void setUp() throws Exception {
		sut = new Calculator();
		hm = new HelpMethods();
	}

	@Test
	public void testAdd() {
		String action = sut.calculateNum("add", "4", "6");

		if (action.equals("ERROR: Invalid operation!")) {
			fail();
		}
		
		int resultNum = hm.parseCalcJsonResult(action);

		int expected = 10;
		int actual = resultNum;

		System.out.println("The sum is: " + resultNum);

		assertEquals(expected, actual);
	}

	@Test
	public void testSubtract() {
		String action = sut.calculateNum("subtract", "5", "4");

		int actual = hm.parseCalcJsonResult(action);
		int expected = 1;

		assertEquals(expected, actual);
	}

	@Test
	public void testMultiply() {
		String action = sut.calculateNum("multiply", "4", "10");

		int actual = hm.parseCalcJsonResult(action);
		int expected = 42;

		assertNotSame(expected, actual);
	}

	@Test
	public void testWrongOperation() {
		String badOperation = sut.calculateNum("divide", "4", "2");
		
		boolean canConvertToInt = hm.isNumeric(badOperation);

		assertFalse(canConvertToInt);
	}
	

}
