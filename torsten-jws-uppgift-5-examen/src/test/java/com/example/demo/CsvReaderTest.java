package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CsvReaderTest {
	
	private CsvReader sut;
	private HelpMethods hm;

	@Before
	public void setUp() throws Exception {
		sut = new CsvReader();
		hm = new HelpMethods();
	}
	
	@Test
	public void testIsJsonFormat() throws FileNotFoundException, IOException {
		String fileName = "sample.csv";
		
		String actual = sut.readFile(fileName);
		
		boolean isJson = hm.isJSONValid(actual);
		
		assertTrue(isJson);
	}

	@Test
	public void testWrongFile() throws FileNotFoundException, IOException {
		String fileName = "wrongfile.csv";
		
		String expected = "ERROR: Failed to find the specified file!";
		String actual = sut.readFile(fileName);
		
		assertEquals(expected, actual);
	}
}
