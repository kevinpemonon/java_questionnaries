package com.teacher.quiz.generatorQuestions;

import java.util.ArrayList;
import com.teacher.quiz.Question;
import com.teacher.quiz.Quizz;

abstract public class QuestionsGenerator {
	
	private static boolean hasPlayed;
	protected Quizz quizz;
	
	public QuestionsGenerator(Quizz quizz) {
		this.quizz = quizz;
	}
	
	abstract public ArrayList<Question> generateAllQuestions(int numberQuestions, Quizz quizz);


	public static boolean getHasPlayed() {
		return hasPlayed;
	}

	public static void setHasPlayed(boolean hasPlayed) {
		QuestionsGenerator.hasPlayed = hasPlayed;
	}
	
}
