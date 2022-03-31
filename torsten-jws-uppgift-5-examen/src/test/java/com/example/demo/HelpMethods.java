package com.example.demo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HelpMethods {

	// Used to check if string can be converted to int
	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			int possibleInt = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// Only returns the result number from JSON file format
	public int parseCalcJsonResult(String jsonString) {
		// What the program will read - {"Operation": "add","First Number": 1,"Second
		// Number": 2,"Result": 3}
		String strippedString = jsonString.replaceAll(".*:", ""); // Removes all characters before the last colon
		String numberString = strippedString.replaceAll("\\D", ""); // Removes all numerics

		int returnInt = Integer.parseInt(numberString);
		return returnInt;
	}
	
	// Returns true if file is parseable to JSON
	public boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}
}
