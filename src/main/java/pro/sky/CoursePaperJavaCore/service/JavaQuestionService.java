package pro.sky.CoursePaperJavaCore.service;

import org.springframework.stereotype.Service;
import pro.sky.CoursePaperJavaCore.exception.QuestionNotFoundException;
import pro.sky.CoursePaperJavaCore.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null ) {
            throw new IllegalArgumentException("Вопрос и ответ не могут быть пустыми!");
        }
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }


    @Override
    public Question remove(Question question) {

        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException("Вопрос не найден!");
    }

    @Override
    public Collection<Question> getAll() {

        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
