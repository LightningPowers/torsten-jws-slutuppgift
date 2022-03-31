package com.example.demo;

public class RPSBean {

	private int games = 0;
	private int wins = 0;
	private int ties = 0;
	private int losses = 0;

	// Run when a game is completed
	public String updateScore(String winStatusString) {
		games++;
		
		String returnString = "";
		
		//Checks for illegal inputs
		if (!winStatusString.equals("Draw!") && 
				!winStatusString.equals("Player Wins!") &&
				!winStatusString.equals("Computer Wins!")) {
			return returnString = "ERROR: Invalid input";
		}

		if (winStatusString.equals("Draw!")) {
			ties++;
		} else if (winStatusString.equals("Player Wins!")) {
			wins++;
		} else if (winStatusString.equals("Computer Wins!")) {
			losses++;
		}
		
		return returnString;
	}

	//Run when getting results from all matches
	public String toJson() {
		String jsonString = "{" + "\"Games\": " + games + "," + "\"Wins\": " + wins + "," + "\"Ties\": " + ties + ","
				+ "\"Losses\": " + losses + "}";
		return jsonString;
	}
}
