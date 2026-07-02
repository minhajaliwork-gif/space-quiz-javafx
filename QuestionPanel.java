package com.solarexplorer.solarexplorer;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.List;





//Displays questions , answers and clues
public class QuestionPanel extends VBox{
	
	private Label typeLabel;
	private Label questionLabel;
	private Label[] clueLabels;
	private Button hintButton;
	private Button[] answerButtons;
	private Label scoreLabel;
	
	//Builds UI components
	public QuestionPanel() {
		
		setSpacing(8);
		setStyle("-fx-background-color: #111122; -fx-padding: 12;");
		
		typeLabel = new Label("Guess the planet");
		typeLabel.setFont(Font.font("Arial", 11));
		typeLabel.setTextFill(Color.rgb(159, 151, 232));
		
		questionLabel = new Label("Which planet am I?");
		questionLabel.setFont(Font.font("Arial", 13));
		questionLabel.setTextFill(Color.rgb(220, 216, 255));
		questionLabel.setWrapText(true);
		
		clueLabels = new Label[4];
		for ( int i = 0 ; i < 4; i++) {
			clueLabels[i] = new Label("???");
			clueLabels[i].setFont(Font.font("Arial", 11));
			clueLabels[i].setTextFill(Color.rgb(80, 80, 100));
			clueLabels[i].setWrapText(true);
			
		}
		
		hintButton = new Button("Get next clue (-50 pts)");
		hintButton.setStyle("-fx-background-color: #1a1a35l; -fx-text-fill: #8888cc; -fx-border-color: #3a34565;");
		hintButton.setMaxWidth(Double.MAX_VALUE);
		
		answerButtons = new Button[4];
		for (int i = 0;  i < 4; i++) {
			answerButtons[i] = new Button("...");
			answerButtons[i].setMaxWidth(Double.MAX_VALUE);
			answerButtons[i].setStyle("-fx-background-color: #0d020; -fx-text-fill: #aaaacc; -fx-border-color: #2a2a42;");
			
			
			
		} 
		
		
		scoreLabel = new Label("Score: 0");
		scoreLabel.setFont(Font.font("Arial", 13));
		scoreLabel.setTextFill(Color.rgb(192, 184, 255));
		
		getChildren().addAll(typeLabel, questionLabel);
		for (Label cl : clueLabels) getChildren().add(cl);
		getChildren().add(hintButton);
		for(Button ab : answerButtons) getChildren().add(ab);
		getChildren().add(scoreLabel);
		
		
		
		
	}
	//Updates panel to show the current conditions like revealed clues
	public void display(Question q , int cluesRevealed) {
		typeLabel.setText(q.getType());
		questionLabel.setText((q.getQuestionText()));
		List<String> options = q.getAnswerOptions();
		
		boolean isGuess = q instanceof GuessPlanetQuestion;
		for ( Label cl : clueLabels) cl.setVisible(isGuess);
		hintButton.setVisible(isGuess);
		
		
		
		for ( int i = 0; i < 4; i++) {
			clueLabels[i].setText("???");
			clueLabels[i].setTextFill(Color.rgb(80, 80,100));
			if (i < options.size()) {
				answerButtons[i].setText(options.get(i));
				answerButtons[i].setStyle("-fx-background-color: #0d0d20; -fx-text-fill: #aaaacc; -fx-border-color: #2a2a42");
				answerButtons[i].setVisible(true);
			}
			else {
				answerButtons[i].setVisible(false);
			}
			
		}
		
		List<String> clues = q instanceof GuessPlanetQuestion ?
				((GuessPlanetQuestion) q).getPlanetClues() :List.of();
		for ( int i = 0; i < cluesRevealed && i < clueLabels.length; i++) {
			if ( i < clues.size()) {
				clueLabels[i].setText("> " + clues.get(i));
				clueLabels[i].setTextFill(Color.rgb(160, 160, 192));
			}
		}
	}
	
	
	
	
	
	
		
		public void updateScore(int score) {
			scoreLabel.setText("Score: " + score);
		}
		
		public Button getHintButton() {
			return hintButton;
		}
		
		public Button[] getAnswerButtons() {
			return answerButtons;
		}
		
		
	}
	
	
	
	
