package com.example.demo;

public class CsvBean {

	private String orderDate;
	private String region;
	private String rep1;
	private String rep2;
	private String item;
	private int units;
	private float unitCost;
	private float total;
	
	public CsvBean(String orderDate, String region, String rep1, String rep2, String item, int units, float unitCost,
			float total) {
		super();
		this.orderDate = orderDate;
		this.region = region;
		this.rep1 = rep1;
		this.rep2 = rep2;
		this.item = item;
		this.units = units;
		this.unitCost = unitCost;
		this.total = total;
	}
	
	public String toJson() {
		String jsonString = "{" + "\"Order Date\": " + "\"" + orderDate + "\"" + "," + "\"Region\": " + "\"" + region + "\"" + "," +
				"\"Rep1\": " + "\"" + rep1 + "\"" + "," + "\"Rep2\": " + "\"" + rep2 + "\"" + "," + "\"Item\": " + "\"" + item + "\"" + "," 
				+ "\"Units\": " + units + "," + "\"Unit Cost\": " + unitCost + "," + "\"Total\": " + total + "}";
		
		return jsonString;
	}	
	
}
