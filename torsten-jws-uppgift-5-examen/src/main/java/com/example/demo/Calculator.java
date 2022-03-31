package com.example.demo;

import java.lang.NumberFormatException;

public class Calculator {

	public String calculateNum(String opType, String num1, String num2) {
		// Write /calc/opType/num1/num2
		int firstNum = 0;
		int secondNum = 0;

		try {
			firstNum = Integer.parseInt(num1);
			secondNum = Integer.parseInt(num2);
		} catch (NumberFormatException e) {
			return "ERROR: could not read number";
		} catch (Exception e) {
			return "ERROR: unknown error";
		}

		//Prevent numbers from getting too large when multiplying
		if (opType.equals("multiply")) {
			if (firstNum > 1000000 || firstNum < -1000000) {
				return "ERROR: a given number contains too many digits for this operation";
			} else if (secondNum > 1000000 || secondNum < -1000000) {
				return "ERROR: a given number contains too many digits for this operation";
			}
		}

		int result = 0;
		String returnString = "";
		if (opType.equals("add")) {
			result = firstNum + secondNum;
			returnString = String.valueOf(result);
		} else if (opType.equals("subtract")) {
			result = firstNum - secondNum;
			returnString = String.valueOf(result);
		} else if (opType.equals("multiply")) {
			result = firstNum * secondNum;
			returnString = String.valueOf(result);
		} else { // Writing something that isn't a valid operation
			returnString = "ERROR: Invalid operation!";
		}
		
		//Checks if there were not any errors given previously before creating JSON
		if (returnString.contains("ERROR")) {
			return returnString;
		}
		else {
			returnString = toJson(opType, firstNum, secondNum, result);
		}
		
		return returnString;
	}

	private String toJson(String operation, int num1, int num2, int result) {
		String returnString = "{" + "\"Operation\": " + "\"" + operation + "\"" + "," + "\"First Number\": " + num1 + "," +
				"\"Second Number\": " + num2 + "," + "\"Result\": " + result + "}";
		return returnString;
	}
	
}
