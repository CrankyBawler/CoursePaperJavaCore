package pro.sky.CoursePaperJavaCore.service;

import pro.sky.CoursePaperJavaCore.model.Question;

import java.util.Collection;
import java.util.HashSet;

public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questions = new HashSet<>();
        if (amount > questionService.getAll().size()) {
            throw new IllegalArgumentException("Количество amount должно быть меньше количества вопросов!");
        }
        int i = 0;
        while (i < amount) {
            Question question = questionService.getRandomQuestion();
            if (!questions.contains(question)) {
                questions.add(question);
                i += 1;

            }
        }


        return questions;
    }

}
