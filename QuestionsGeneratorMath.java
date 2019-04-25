package com.teacher.quiz.generatorQuestions;

import java.util.ArrayList;
import java.util.Random;

import com.teacher.quiz.Question;
import com.teacher.quiz.Quizz;

public class QuestionsGeneratorMath extends QuestionsGenerator {
	
	public QuestionsGeneratorMath(Quizz quizz) {
		super(quizz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Question> generateAllQuestions(int numberQuestions, Quizz quizz) {
		setHasPlayed(true);
		String[] operators = {"+", "-", "*", "/"};
		ArrayList<Question> allQuestions = new ArrayList<Question>();
		Random random = new Random();
		
		for (int i = 0; i < numberQuestions; i++) {	
			
			String operator = operators[random.nextInt(3)];
			int number1 = random.nextInt(10);
			int number2 = random.nextInt(10);
			if (number2 == 0)
				number2++;
			
			String result = calculate(operator, number1, number2);
			
			Question question = new Question(String.format("%s %s %s = ?", number1, operator, number2), result);
			allQuestions.add(question);
		}
		return allQuestions;
	}
	
	public String calculate(String operator, int number1, int number2) {
		int result = 0;
		
		switch(operator){
		case "+":
			result = number1 + number2;
			break;
		case "-":
			result = number1 - number2;
			break;
		case "*":
			result = number1 * number2;
			break;
		case "/":
			result = number1 / number2;
			break;
		}
		return String.valueOf(result);
	}

}
