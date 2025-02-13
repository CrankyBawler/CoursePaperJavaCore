package pro.sky.CoursePaperJavaCore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CoursePaperJavaCore.exception.QuestionNotFoundException;
import pro.sky.CoursePaperJavaCore.model.Question;
import pro.sky.CoursePaperJavaCore.service.JavaQuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    void add() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();
        Question expected = new Question("question1", "answer1");
        Question actual = javaQuestionService.add("question1", "answer1");

        assertEquals(expected, actual);
    }


    @Test
    void remove() {
        Set<Question> questions = new HashSet<>();
        javaQuestionService.add("Question1", "Answer1");
        questions.add(new Question("Question2", "Answer2"));
        questions.add(new Question("Question3", "Answer3"));

        when(javaQuestionService.getAll()).thenReturn(questions);

        Question questionRemove = new Question("Question2", "Answer2");
        Question questionNotFound = new Question("Question4", "Answer4");

        Question removedQuestion = javaQuestionService.remove(questionRemove);

        assertEquals(2, javaQuestionService.getAll().size());
        assertEquals(questionRemove, removedQuestion);
        assertFalse(javaQuestionService.getAll().contains(questionRemove));
        QuestionNotFoundException questionNotFoundException = assertThrows(QuestionNotFoundException.class, () -> {
            javaQuestionService.remove(questionNotFound);
        });
        assertEquals("Вопрос не найден!", questionNotFoundException.getMessage());
    }
}
