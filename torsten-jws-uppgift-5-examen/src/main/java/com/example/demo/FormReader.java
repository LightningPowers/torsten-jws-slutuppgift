package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class FormReader {

	public String readFile(String fileName) throws FileNotFoundException, IOException 
	{
		var csvFile = new ClassPathResource(fileName);
		String result = "";	
		
		try (Scanner scan = new Scanner(csvFile.getFile())) {
			while(scan.hasNextLine())
			{
				result += (scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			return "ERROR: Failed to find the specified file!";
		} catch (IOException e) {
			return "ERROR: Unknown exception!";
		}

		return result;
	}
	
	
}
