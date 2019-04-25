package com.teacher.quiz;

import java.util.Scanner;

import com.teacher.quiz.generatorQuestions.QuestionsGeneratorCapitales;
import com.teacher.quiz.generatorQuestions.QuestionsGeneratorMath;

public class Option {
	
	private Scanner sc = new Scanner(System.in);
	
	public int getTypeOfVisual() {
		System.out.println("Quelle interface voulez-vous ? \n1 - Console \n2 - Interface Graphique");
		int answerTypeOfVisual = sc.nextInt();
		return answerTypeOfVisual;
	}
	
	public int getTypeOfQuestionnary() {
		System.out.println("Quel questionnaire voulez-vous ? \n1 - Capitales \n2 - Arithmétique");
		int answerTypeOfQuestionnary = sc.nextInt();
		return answerTypeOfQuestionnary;
	}
	
	public Quizz getGame() {
		
		Quizz game = null;
		Option option = new Option();
		int answerTypeOfVisual = option.getTypeOfVisual();
		int answerTypeOfQuestionnary = option.getTypeOfQuestionnary();
		
		if (answerTypeOfVisual == 1) {
			if (answerTypeOfQuestionnary == 1)	
				game = new ConsoleQuizz(new QuestionsGeneratorCapitales(game));
			else
				game = new ConsoleQuizz(new QuestionsGeneratorMath(game));
		}

		if (answerTypeOfVisual == 2)
			if (answerTypeOfQuestionnary == 1)	
				game = new GUIQuizz(new QuestionsGeneratorCapitales(game));
			else
				game = new GUIQuizz(new QuestionsGeneratorMath(game));
		
		return game;
	}
}
