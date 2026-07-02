package com.solarexplorer.solarexplorer;

import java.util.List;

//Concrete Question Type - Player guesses the planet form the clues
public class GuessPlanetQuestion implements Question {
	
	private Planet planet;
	private List<String> options;
	
	//Shuffles answer options but gurantees correct answer is included
	public GuessPlanetQuestion(Planet planet, List<String> allPlanetNames) {
		this.planet = planet;
		List<String> shuffled = new java.util.ArrayList<>(allPlanetNames);
		java.util.Collections.shuffle(shuffled);
		shuffled.remove(planet.getname());
		shuffled =  shuffled.subList(0, 3);
		List<String> finalOptions = new java.util.ArrayList<>(shuffled);
		finalOptions.add(0, planet.getname());
		java.util.Collections.shuffle(finalOptions);
		this.options = finalOptions;
	}
	
	public String getQuestionText() {
		return "Which planet am I ? Use the clues to find out!";
	}
	
	
	public List<String> getAnswerOptions(){
		return options;
	}
	
	public String getCorrectAnswer() {
		return planet.getname();
	}
	
	public String getType() {
		return "Guess the planet";
	}
	
	public List<String> getPlanetClues(){
		return planet.getClues();
		
	}
	

}
