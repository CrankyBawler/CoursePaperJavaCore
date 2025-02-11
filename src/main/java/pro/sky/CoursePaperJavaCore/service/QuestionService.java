package pro.sky.CoursePaperJavaCore.service;

import pro.sky.CoursePaperJavaCore.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);


    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
