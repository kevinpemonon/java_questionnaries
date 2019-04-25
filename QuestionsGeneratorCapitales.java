package com.teacher.quiz.generatorQuestions;

import java.util.ArrayList;
import java.util.Random;

import com.teacher.quiz.Question;
import com.teacher.quiz.Quizz;

public class QuestionsGeneratorCapitales extends QuestionsGenerator {

	private int index;

	public QuestionsGeneratorCapitales(Quizz quizz) {
		super(quizz);
	}
	
	@Override
	public ArrayList<Question> generateAllQuestions(int numberQuestions, Quizz quizz) {
		
		String[][] data = getData();
		ArrayList<Question> allQuestions = new ArrayList<Question>();
		if (numberQuestions > data.length) {		
			setHasPlayed(false);
			quizz.displayMessage(String.format("Il n'y a que %s questions disponibles...", data.length));
		} else {
			setHasPlayed(true);
			ArrayList<Integer> arrayOfIndex = new ArrayList<>();
			Random random = new Random();
			for (int i = 0; i < numberQuestions; i++) {
				do {
					index = random.nextInt(data.length);
				} while (arrayOfIndex.contains(index));
				arrayOfIndex.add(index);
				
				String pays = data[index][0];
				String capitale = data[index][1];
				Question question = new Question(String.format("Quelle est la capitale de ce pays %s ?", pays), capitale);
				allQuestions.add(question);
			}
		}
		return allQuestions;
	}
	
	public String[][] getData() {
		String[][] data = { { "France", "Paris" }, { "Allemagne", "Berlin" }, { "Colombie", "Bogota" }, { "Japon", "Tokyo" } };
		return data;
	}
}
