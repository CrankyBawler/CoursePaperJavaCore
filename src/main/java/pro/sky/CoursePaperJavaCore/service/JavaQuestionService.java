package pro.sky.CoursePaperJavaCore.service;

import pro.sky.CoursePaperJavaCore.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JavaQuestionService implements QuestionService {

    private List<Question> questions = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        if (question == null || question.isEmpty() || answer == null || answer.isEmpty()) {
            throw new IllegalArgumentException("Вопрос и ответ не могут быть пустыми!");
        }
        Question newQuestion = new Question(question, answer);

        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
