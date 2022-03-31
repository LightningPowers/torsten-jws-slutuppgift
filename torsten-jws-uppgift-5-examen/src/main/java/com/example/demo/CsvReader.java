package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class CsvReader {

	private ArrayList<CsvBean> beanList = new ArrayList<CsvBean>();
	
	public String readFile(String fileName) throws FileNotFoundException, IOException 
	{
		var csvFile = new ClassPathResource(fileName);
		try (Scanner scan = new Scanner(csvFile.getFile())) {
			scan.nextLine(); //Skips the first row
			while(scan.hasNextLine())
			{
				addBean(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			return "ERROR: Failed to find the specified file!";
		} catch (IOException e) {
			return "ERROR: Unknown exception!";
		}

		return beansToJson();
	}
	
	private void addBean(String textLine) {
		String orderDate = null, region = null, rep1 = null, rep2 = null, item = null;
		int units = 0;
		float unitCost = 0;
		float total = 0;
		
		Scanner csvScanner = new Scanner(textLine);
		csvScanner.useDelimiter(",");

		//Goes through the row and assigns each one to their variable
		orderDate = csvScanner.next();
		region = csvScanner.next();
		rep1 = csvScanner.next();
		rep2 = csvScanner.next();
		item = csvScanner.next();
		units = Integer.parseInt(csvScanner.next());
		unitCost = Float.parseFloat(csvScanner.next());
		total = Float.parseFloat(csvScanner.next());
		
		//TODO Loop (while?) through each and assign each item to a string arraylist?

		CsvBean newBean = new CsvBean(orderDate, region, rep1, rep2, item, units, unitCost, total);
		beanList.add(newBean); //Adds the created bean to list
		csvScanner.close();
	}
	
	//Loops through bean list, adds them to JSON file structure
	private String beansToJson() {
		String jsonString = "";
		String beanObjectString = "";
		String allBeanString = "";
		
		for(CsvBean bean : beanList) {
			beanObjectString += bean.toJson() + ",";
		}
		allBeanString = beanObjectString.substring(0, beanObjectString.lastIndexOf(",")); //Removes last comma
		
		jsonString = "[" + allBeanString + "]";
		
		return jsonString;
	}
	
}
