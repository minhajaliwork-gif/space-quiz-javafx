package com.solarexplorer.solarexplorer;

import javafx.scene.canvas.GraphicsContext;
import java.util.Arrays;
import java.util.List;


public class GameController {
	
	private GameCanvas canvas;
	private QuestionPanel panel;
	private GameState state;
	private List<Planet> planets;
	private Planet activePlanet;
	private Question currentQuestion;
	private GraphicsContext gc;
	
	//Sets up game and starts the first round
	public GameController(GameCanvas canvas , QuestionPanel panel, GraphicsContext gc) {
		this.canvas = canvas;
		this.panel = panel;
		this.gc = gc;
		this.state = new GameState();
		setupPlanets();
		setupHandlers();
		nextRound();
	}
	
	//Creates 8 planets with their data
	private void setupPlanets() {
		planets = Arrays.asList(
				new Planet(gc, 370, 240 , "Mercury", javafx.scene.paint.Color.GRAY,8, 0, 60,List.of("I am the closest to the Sun", "I have no moons","I have no atmosphere", "I am very hot in the day and cold at night")),
				new Planet(gc, 340, 180 , "Venus", javafx.scene.paint.Color.ORANGE,12, 0, 100,List.of("I am the hottest planet", "I have no moons","I spin backwards", "I am covered in thick clouds")),
				new Planet(gc, 430, 240 , "Earth", javafx.scene.paint.Color.BLUE,13, 1, 45,List.of("I support life", "I have one moons","I am mostly covered in water", "I am the third planet from the sun")),
				new Planet(gc, 340, 340 , "Mars", javafx.scene.paint.Color.GRAY,10, 2, 185,List.of("I am called the Red Planet", "I have two moons","I have the tallest volcano", "I may have had water once")),
				new Planet(gc, 170, 230 , "Jupiter", javafx.scene.paint.Color.ORANGE,25, 95, 150,List.of("I am the largest planet", "I have a giant red spot","I have 95 known  moons", "I am a gas giant")),
				new Planet(gc, 340, 430 , "Saturn", javafx.scene.paint.Color.YELLOW,22, 146, 310,List.of("I have beautiful rings", "I am a gas giant","I have 146 moons ", "I am less dense than water")),
				new Planet(gc, 490, 240 , "Uranus", javafx.scene.paint.Color.CYAN,16, 28, 370,List.of("I rotate in my side ", "I am an ice giant","I have 28 moons ", "I appear blue-green")),
				new Planet(gc, 360, 60 , "Neptune", javafx.scene.paint.Color.BLUE,15, 16, 420,List.of("I am the windiest planet", "I am furthest from the sun","I have 16 moons", "I am an ice giant"))
				
			
				
				);
	}
	//Handles hints and button clicks
	private void setupHandlers() {
		panel.getHintButton().setOnAction(e -> {
			if (state.getCluesRevealed() < 4) {
				state.deductPoints(50);
				state.revealClue();
				panel.display(currentQuestion,  state.getCluesRevealed());
				panel.updateScore(state.getScore());
				
			}
		});
		
		for (int i = 0; i < panel.getAnswerButtons().length; i++) {
			final int idx = i;
			
			panel.getAnswerButtons()[idx].setOnAction(e -> {
				String chosen = panel.getAnswerButtons()[idx].getText();
				if (chosen.equals(currentQuestion.getCorrectAnswer())) {
					int points = Math.max(50, 200 - state.getCluesRevealed()* 50);
					state.addPoints(points);
					panel.updateScore(state.getScore());
					panel.getAnswerButtons()[idx].setStyle("-fx-background-color: #0a1f14; -fx-text-fill: #5dcaa5; -fx-border-color: #1d9e75");
					nextRound();
					
				} else {
					panel.getAnswerButtons()[idx].setStyle("-fx-background-color: #1f0a0a; -fx-text-fill: #f0997b; -fx-border-color: #993c1d");
				}
			});
			
		
			
			
		}
		
		
			
		}
		//Picks a random planet and question type for the next round
	private void nextRound() {
		state.nextRound();
		int idx = (int)(Math.random() * planets.size());
		activePlanet = planets.get(idx);
		List<String> names = Arrays.asList("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune");
		String[] types = {"guess", "truefalse","stat"};
		String type = types[(int)(Math.random() * types.length)];
		currentQuestion = QuestionFactory.create(type, activePlanet, names);
		canvas.render(planets, activePlanet);
		panel.display(currentQuestion, 0);
		panel.updateScore(state.getScore());
		
		
		
		
		
	}
	
	
	

}
