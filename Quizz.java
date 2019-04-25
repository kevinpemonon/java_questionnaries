package com.teacher.quiz;

import com.teacher.quiz.generatorQuestions.QuestionsGenerator;

abstract public class Quizz {
	
	private String numberOfQuestions;
	private int goodAnswer = 0;
	private long startTime;
	private long endTime;
	private long timeElapsed;
	private QuestionsGenerator generatorOfQuestions;
	
	public Quizz (QuestionsGenerator generator) {
		this.generatorOfQuestions = generator;
	}

	abstract public void displayMessage(String format);
	
	abstract public String retrieveAnswer(String text);

	public void start() {
		startTime = System.currentTimeMillis();
		for (Question question : generatorOfQuestions.generateAllQuestions(Integer.parseInt(getNumberOfQuestions()), this)) {
			String answer = retrieveAnswer(question.getText());
			checkAnswer(question, answer);
		};
		endTime = System.currentTimeMillis();
		timeElapsed = (endTime - startTime)/1000;
	};
	
	public String getNumberOfQuestions() {
		return numberOfQuestions = retrieveAnswer("Combien de questions voulez-vous ?");
	}

	public boolean checkAnswer(Question question, String answer) {
		boolean checkAnswer = false;
		if (answer.toLowerCase().equals(question.getResponse().toLowerCase()))
			checkAnswer = true;		
		if (checkAnswer) {
			displayMessage("Bonne réponse!");
			goodAnswer++;
		} else {
			displayMessage("Mauvaise réponse...");
		}
		return checkAnswer;
	};
	
	public void displayResults(boolean hasPlayed) {
		if(hasPlayed) {			
			displayMessage("\nVous avez " + goodAnswer + "/" + numberOfQuestions + " bonnes réponses !"
					+ "\nVous avez mis " + timeElapsed + " secondes pour terminer le quizz.");
		}
	}
}
