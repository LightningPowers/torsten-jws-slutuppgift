package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FormReaderTest {
	
	private FormReader sut;

	@Before
	public void setUp() throws Exception {
		sut = new FormReader();
	}
	
	@Test
	public void testCorrectFile() throws FileNotFoundException, IOException {
		String fileName = "wrongform.html";
		
		String expected = "ERROR: Failed to find the specified file!";
		String actual = sut.readFile(fileName);
		
		assertEquals(expected, actual);
	}

	@Test
	public void testWrongFile() throws FileNotFoundException, IOException {
		String fileName = "wrongform.html";
		
		String expected = "ERROR: Failed to find the specified file!";
		String actual = sut.readFile(fileName);
		
		assertEquals(expected, actual);
	}
}
