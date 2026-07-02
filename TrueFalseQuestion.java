package com.solarexplorer.solarexplorer;

import java.util.Arrays;
import java.util.List;



public class TrueFalseQuestion implements Question{
	
	private String questionText;
	private String correctAnswer;
	
	public TrueFalseQuestion(String questionText, String correctAnswer) {
		this.questionText = questionText;
		this.correctAnswer = correctAnswer;
	
}

public String getQuestionText() {
	return questionText;
}

public List<String> getAnswerOptions(){
	return Arrays.asList("True", "False");

}

public String getCorrectAnswer() {
	return correctAnswer;
	
}

public String getType() {
	return "True or False";


}

}

