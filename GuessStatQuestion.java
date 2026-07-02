package com.solarexplorer.solarexplorer;
import java.util.List;

//Concrete Question Type - Player Guesses a planets statistics
public class GuessStatQuestion implements Question {
	private Planet planet;
	private String statType;
	private List<String> options;
	private String correctAnswer;
	
	public GuessStatQuestion(Planet planet , String statType, List<String> options , String correctAnswer) {
		
		this.planet = planet;
		this.statType = statType;
		this.options = options;
		this.correctAnswer = correctAnswer;
		
		
	}
	
	public String getQuestionText() {
		return "How many moons does " + planet.getname() + " have?";
	}
	
	public List<String> getAnswerOptions(){
		return options;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
		
	}
	
	public String getType() {
		return "Guess the stat";
	}
	

}
