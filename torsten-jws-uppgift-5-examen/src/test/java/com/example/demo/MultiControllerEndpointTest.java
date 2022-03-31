package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class MultiControllerEndpointTest {

private String sut;
private HelpMethods hm;
	
	@Before
	public void setUp() throws Exception {
		sut = "http://localhost:8080";
		hm = new HelpMethods();
	}
	
	@Test
	public void testCalc() throws IOException{
		String expected = "32";
		String unExpected = "ERROR: Invalid operation!";
		
		String testOperator = "multiply";
		String num1 = "4";
		String num2 = "8";
		
		String url = sut + "/calc";
		String parameters = "/" + testOperator + "/" + 
		num1 + "/" + num2;
		String query = url + parameters;
		String request = httpHelper.UrlResponse(query, "get", null);
		
		int convertedNum = hm.parseCalcJsonResult(request);
		String actual = Integer.toString(convertedNum);
		
		assertEquals(expected, actual);
		assertNotEquals(unExpected, actual);
	}

	@Test
	public void testCalcIllegalParams() throws IOException{
		String testOperator = "add";
		String num1 = "4";
		String num2 = "Forty";
		
		String expected = "ERROR: could not read number";
		
		String url = sut + "/calc";
		String parameters = "/" + testOperator + "/" + 
		num1 + "/" + num2;
		String query = url + parameters;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRPSGameResult() throws IOException {
		String url = sut + "/rps";
		String query = url;
		String body = "choice=rock";
		String actual = httpHelper.UrlResponse(query, "post", body);
		
		boolean isJson = hm.isJSONValid(actual);
		
		assertTrue(isJson);
	}
	
	@Test
	public void testRPSMatchesResult() throws IOException {
		String url = sut + "/rps";
		String query = url;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		boolean isJson = hm.isJSONValid(actual);
		
		assertTrue(isJson);
	}
	
	@Test
	public void testCsvReader() throws IOException {
		
		String url = sut + "/csv";
		String query = url;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		boolean isJson = hm.isJSONValid(actual);
		
		assertTrue(isJson);
	}
	
	@Test
	public void testImageRandomizer() throws IOException {
		//http://jubin.tech/articles/2018/12/05/Detect-image-format-using-java.html
		byte[] jpgHeader = new byte[] { (byte) 0xEF, (byte) 0xBF, (byte) 0xBD }; //Change first 3 bytes depending on file format

		String url = sut + "/img";
		String query = url;
		var img = httpHelper.UrlResponse(query, "GET", null);
		byte[] imgBytes = img.getBytes();

		int i = 0;
		for (byte b : jpgHeader) {
			if (imgBytes[i++] != b)
				assertTrue(false);
		}

		assertTrue(true);
	}
	
	@Test
	public void testFormReader() throws IOException {
		String expected = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\">"
				+ "<title>Select your Choice</title></head><body><!-- Needs the "
				+ "spring project to be active to perform action --><form method=\"POST\" "
				+ "action=\"http://localhost:8080/rps\">		 <label for=\"choice\">Select your Choice:</label>"
				+ "	<select name=\"choice\" id=\"choices\">  		<option value=\"Rock\">Rock</option>"
				+ "  		<option value=\"Paper\">Paper</option>  		<option value=\"Scissors\">Scissors</option>"
				+ "	</select> 	<input type=\"submit\" value=\"ok\"></form></body></html>";
		
		String url = sut + "/rpsform";
		String query = url;
		String actual = httpHelper.UrlResponse(query, "get", null);
		
		assertEquals(expected, actual);
	}
}
