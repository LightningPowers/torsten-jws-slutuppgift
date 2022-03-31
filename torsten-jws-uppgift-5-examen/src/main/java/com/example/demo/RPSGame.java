package com.example.demo;

public class RPSGame {

	private String winStatus;
	
	public String runGame(String playerChoice) {
		String jsonReturnValue = "";
		String winnerStatus = "";
		
		//Checks for illegal input, randomizes player choice if illegal
		if (!playerChoice.equals("Rock") && !playerChoice.equals("Paper") && !playerChoice.equals("Scissors")) {
			double randomChoice = Math.random();
			if (randomChoice <= 0.33) {
				playerChoice = "Rock";
			} else if (randomChoice > 0.33 && randomChoice <= 0.66) {
				playerChoice = "Paper";
			} else {
				playerChoice = "Scissors";
			}
		}
		
		//Generates choice for computer
		String computerChoice = "";
		double aiWeight = Math.random();
		if (aiWeight <= 0.33) {
			computerChoice = "Rock";
		} else if (aiWeight > 0.33 && aiWeight <= 0.66) {
			computerChoice = "Paper";
		} else {
			computerChoice = "Scissors";
		}
		
		//Logic for the game, comparing player and ai choices
		if (playerChoice.equals("Rock") && computerChoice.equals("Scissors")
				|| playerChoice.equals("Paper") && computerChoice.equals("Rock")
				|| playerChoice.equals("Scissors") && computerChoice.equals("Paper")) {
			winnerStatus = "Player Wins!";
		} else if (computerChoice.equals("Rock") && playerChoice.equals("Scissors")
				|| computerChoice.equals("Paper") && playerChoice.equals("Rock")
				|| computerChoice.equals("Scissors") && playerChoice.equals("Paper")) {
			winnerStatus = "Computer Wins!";
		} else {
			winnerStatus = "Draw!";
		}
		
		//Saves the winner for this (latest) match
		setWinner(winnerStatus);
		
		//Turns data into json format
		jsonReturnValue = toJson(playerChoice, computerChoice, winnerStatus);
		return jsonReturnValue;
	}
	
	private void setWinner(String newStatus) {
		winStatus = newStatus;
	}
	
	public String getWinStatus() {
		return winStatus;
	}
	
	private String toJson(String choice, String computerChoice, String winner) {
		String returnString = "{" + "\"Player Move\": " + "\"" + choice + "\"" + "," 
				+ "\"Computer Move\": " + "\"" + computerChoice + "\"" + ","
				+ "\"Winner\": " + "\"" + winner + "\"" + "}";
		
		return returnString;
	}
	
}
