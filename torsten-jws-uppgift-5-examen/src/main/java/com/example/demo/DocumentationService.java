package com.example.demo;

public class DocumentationService {
	
	private String title = "Api Documentation";
	private String header = "API Documentation";

	public String getDocumentation () {
		String page = "";
		page += "<html><head>";
		page += "<title>" + title + "</title></head><body>";
		page += "<h2>" + header + "</h2>";
		page += "<p></p>";
		page += getCalcDocumentation();
		page += getRPSDocumentation();
		page += getCsvDocumentation();
		page += getImageDocumentation();
		
		return page;
	}
	
	//Documentation for calculator
	private String getCalcDocumentation() {
		String content = "";
		String name = "Calculator";
		String desc = "Calculates the result of a given operation with two given numbers.";
		String url = "/calc/operation/num1/num2";
		String link = "http://localhost:8080/calc/add/1/2";
		String linkText = "Example Usecase";
		String output = "Returns given operation, numbers and the resulting number in JSON format.";
		
		content += "<details>" + "<summary>" + name + "</summary>";
		content += "<h3>" + name + "</h3>";
		
		content += "<p></p><hr>";
		content += "<h4>" + "Description: " + desc + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "URL: " + url + "</h4>";
		content += "<p></p><hr>";
		content += "<h4><a href=" + link + ">" + linkText + "</a></h4>";
		content += "<p></p><hr>";
		content += "<h3>" + "Parameters: </h3>";
		content += "<p></p>";
		content += "<h4>" + "operation (string) - Can choose between \"add\", \"subtract\" or \"multiply\"." + "</h4>";
		content += "<p></p>";
		content += "<h4>" + "num1 (int) - A positive or negative number without decimals." + "</h4>";
		content += "<p></p>";
		content += "<h4>" + "num2 (int) - A positive or negative number without decimals." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Verb: " + "GET" + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Output: " + output + "</h4>";
		content += "<p></p><hr>";
		content += "</details>";
		
		return content;
	}
	
	//Documentation for rock paper scissors game
	private String getRPSDocumentation() {
		String content = "";
		String name = "Rock Paper Scissors";
		String url = "/rps";
		String link1 = "http://localhost:8080/rpsform";
		String linkText1 = "Link to Form";
		String link2 = "http://localhost:8080/rps";
		String linkText2 = "Example Usecase";
		
		content += "<details>" + "<summary>" + name + "</summary>";
		content += "<h3>" + name + "</h3>";
		
		//First dropdown for rps POST
		content += "<details>" + "<summary>" + "Running the Game" + "</summary>";
		content += "<h4>" + "Description: " + "The player plays rock, paper, scissors with computer, which also saves match data." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "URL: " + url + "</h4>";
		content += "<p></p><hr>";
		content += "<h4><a href=" + link1 + ">" + linkText1 + "</a></h4>";
		content += "<p></p><hr>";
		content += "<h3>" + "Parameters: </h3>";
		content += "<p></p>";
		content += "<h4>" + "choice (string) - Player chooses between rock, paper or scissors." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Verb: " + "POST" + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Output: " + "Returns result from the latest match in JSON with for example \"Winner:\" \"Player Wins!\"." + "</h4>";
		content += "<p></p><hr>";
		content += "</details>";
		
		//Second dropdown for rps GET
		content += "<details>" + "<summary>" + "Get Match Results" + "</summary>";
		content += "<h4>" + "Description: " + "The player can see the match data from all games." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "URL: " + url + "</h4>";
		content += "<p></p><hr>";
		content += "<h4><a href=" + link2 + ">" + linkText2 + "</a></h4>";
		content += "<p></p><hr>";
		content += "<h3>" + "Parameters: </h3>";
		content += "<p></p>";
		content += "<h4>" + "No parameters." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Verb: " + "GET" + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Output: " + "Returns result from all matches in JSON format. Includes wins, losses and more." + "</h4>";
		content += "<p></p><hr>";
		content += "</details>";
			
		content += "</details>";
		
		return content;
	}
	
	//Docs for CSV to JSON
	private String getCsvDocumentation() {
		String content = "";
		String name = "CSV Reader";
		String desc = "Converts a CSV file to JSON format.";
		String url = "/csv";
		String link = "http://localhost:8080/csv";
		String linkText = "Example Usecase";
		String output = "Returns a list of all items from a CSV file in JSON format.";
		
		content += "<details>" + "<summary>" + name + "</summary>";
		content += "<h3>" + name + "</h3>";
		
		content += "<p></p><hr>";
		content += "<h4>" + "Description: " + desc + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "URL: " + url + "</h4>";
		content += "<p></p><hr>";
		content += "<h4><a href=" + link + ">" + linkText + "</a></h4>";
		content += "<p></p><hr>";
		content += "<h3>" + "Parameters: </h3>";
		content += "<p></p>";
		content += "<h4>" + "No parameters." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Verb: " + "GET" + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Output: " + output + "</h4>";
		content += "<p></p><hr>";
		content += "</details>";
		
		return content;
	}
	
	//Docs for Image Randomizer
	private String getImageDocumentation() {
		String content = "";
		String name = "Image Randomizer";
		String desc = "Shows a random out of 5 possible images.";
		String url = "/img";
		String link = "http://localhost:8080/img";
		String linkText = "Example Usecase";
		String output = "Returns an randomized JPG image.";
		
		content += "<details>" + "<summary>" + name + "</summary>";
		content += "<h3>" + name + "</h3>";
		
		content += "<p></p><hr>";
		content += "<h4>" + "Description: " + desc + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "URL: " + url + "</h4>";
		content += "<p></p><hr>";
		content += "<h4><a href=" + link + ">" + linkText + "</a></h4>";
		content += "<p></p><hr>";
		content += "<h3>" + "Parameters: </h3>";
		content += "<p></p>";
		content += "<h4>" + "No parameters." + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Verb: " + "GET" + "</h4>";
		content += "<p></p><hr>";
		content += "<h4>" + "Output: " + output + "</h4>";
		content += "<p></p><hr>";
		content += "</details>";
		
		return content;
	}
}
