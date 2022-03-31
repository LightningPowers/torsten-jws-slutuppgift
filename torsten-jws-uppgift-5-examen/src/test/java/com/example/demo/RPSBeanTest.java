package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RPSBeanTest {

	private RPSBean sut;
	@Before
	public void setUp() throws Exception {
		sut = new RPSBean();
	}

	@Test
	public void testWrongString() {
		String illegalString = "Spectator Wins!";
		
		String actual = sut.updateScore(illegalString);
		
		String expected = "ERROR: Invalid input";
		
		assertEquals(expected, actual);
	}
}
