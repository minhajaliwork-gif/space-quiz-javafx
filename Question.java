package com.solarexplorer.solarexplorer;
import java.util.List;

public interface Question {
	String getQuestionText();
	List<String> getAnswerOptions();
	String getCorrectAnswer();
	String getType();
	
}
