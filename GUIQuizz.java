package com.teacher.quiz;

import javax.swing.JOptionPane;

import com.teacher.quiz.generatorQuestions.QuestionsGenerator;

public class GUIQuizz extends Quizz{

	public GUIQuizz(QuestionsGenerator generator) {
		super(generator);
	}

	@Override
	public void displayMessage(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	public String retrieveAnswer(String text) {
		return JOptionPane.showInputDialog(text);
	}
}

