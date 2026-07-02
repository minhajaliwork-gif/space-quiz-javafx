package com.solarexplorer.solarexplorer;

import java.util.Arrays;
import java.util.List;


public class QuestionFactory {
	
	public static Question create(String type , Planet planet , List<String> allNames) {
		
		switch (type) {
		case "guess":
			return  new GuessPlanetQuestion(planet , allNames);
		case "truefalse":
			return new TrueFalseQuestion(
					"True or False: " + planet.getname() + " has " + planet.getMoons() + " moons?",
					"True"
					);
		case "stat":
			return new GuessStatQuestion(
					planet,
					"moons",
					Arrays.asList(
						String.valueOf(planet.getMoons()),
						String.valueOf(planet.getMoons() + 2),
						String.valueOf(Math.max(0,  planet.getMoons() -1)),
						String.valueOf(planet.getMoons() + 5)
						
					),
					String.valueOf(planet.getMoons())
					
					);
					
					
					

			default:
			return new GuessPlanetQuestion(planet , allNames);
			
			
			
			
			
		}
			
			
			
			
		}
}
		
	

