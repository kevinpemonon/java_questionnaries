package com.teacher.quiz;

import com.teacher.quiz.generatorQuestions.QuestionsGeneratorCapitales;

public class Test {

	public static void main(String[] args) {
		Quizz game = null;
		Option option = new Option();
		String replayResponse;

		do {
			game = option.getGame();
			game.start();
			game.displayResults(QuestionsGeneratorCapitales.getHasPlayed());
			replayResponse = game.retrieveAnswer("\nVoulez-vous rejouer ? (o/n)");
			
		} while(!replayResponse.equals("n"));
		
		game.displayMessage("Merci d'avoir joué!");
	}
}
