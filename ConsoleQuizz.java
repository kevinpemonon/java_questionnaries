package com.teacher.quiz;

import java.util.Scanner;

import com.teacher.quiz.generatorQuestions.QuestionsGenerator;

public class ConsoleQuizz extends Quizz {

	public ConsoleQuizz(QuestionsGenerator generator) {
		super(generator);
	}

	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void displayMessage(String text) {
		System.out.println(text);
	}

	@Override
	public String retrieveAnswer(String text) {
		displayMessage(text);
		return sc.next();
	}
}
