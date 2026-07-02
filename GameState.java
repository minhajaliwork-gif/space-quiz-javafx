package com.solarexplorer.solarexplorer;


//Model class - Stores the game data like score round (Part of the MVC design)

public class GameState {
	private int score;
	private int round;
	private int cluesRevealed;
	
	
	public GameState() {
		this.score = 0;
		this.round =1;
		this.cluesRevealed =0 ;
	}
	
	public void addPoints(int points) {
		score += points;
		
	}
	
	public void deductPoints(int points) {
		score -= points;
		
	}
	
	public void nextRound() {
		round++ ;
		cluesRevealed = 0;
	}
	
	
	public void revealClue() {
		cluesRevealed++ ;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getRound() {
		return round;
		
	}
	
	public int getCluesRevealed() {
		return cluesRevealed;
	}
}

