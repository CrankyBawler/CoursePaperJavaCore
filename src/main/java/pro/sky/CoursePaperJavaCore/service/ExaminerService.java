package pro.sky.CoursePaperJavaCore.service;

import pro.sky.CoursePaperJavaCore.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
