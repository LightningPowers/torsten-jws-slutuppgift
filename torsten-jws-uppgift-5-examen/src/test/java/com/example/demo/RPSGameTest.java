package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RPSGameTest {

	private RPSGame sut;
	private HelpMethods hm;

	@Before
	public void setUp() throws Exception {
		sut = new RPSGame();
		hm = new HelpMethods();
	}
	
	@Test
	public void testRunGame() {
		String testChoice = "Paper";
		
		String actual = sut.runGame(testChoice);
		
		boolean isJson = hm.isJSONValid(actual);
		
		assertTrue(isJson);
	}
	
	@Test
	public void testInvalidParam() {
		String testChoice = "Shotgun";
		
		String actual = sut.runGame(testChoice);
		boolean expected = true;
		
		boolean isJson = hm.isJSONValid(actual);
		
		assertEquals(expected, isJson);
	}
	
	@Test
	public void testGetWinStatus() {
		String actual = sut.getWinStatus();
		String expected = null;
		
		assertEquals(expected, actual);
	}
}
