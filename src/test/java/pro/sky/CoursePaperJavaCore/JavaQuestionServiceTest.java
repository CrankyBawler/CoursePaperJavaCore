package pro.sky.CoursePaperJavaCore;

import com.sun.nio.sctp.IllegalUnbindException;
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
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
            javaQuestionService.add(null, null);
        });
    }

    @Test
    void find() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();

        javaQuestionService.add("question1", "answer1");
        javaQuestionService.add("question2", "answer2");
        javaQuestionService.add("question3", "answer3");

        Question expected = new Question("question1", "answer1");
        Question notFoundQuestion = new Question("question4", "answer4");
        Question actual = new Question("question1", "answer1");


        Question atcual = javaQuestionService.find(actual);

        assertEquals(expected, atcual);
        QuestionNotFoundException questionNotFoundException = assertThrows(QuestionNotFoundException.class, () -> {
            javaQuestionService.find(notFoundQuestion);
        });

    }


    @Test
    void remove() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();
        Question question = new Question("question1", "answer1");
        Question notFoundQuestion = new Question("question2", "answer2");

        javaQuestionService.add("question1", "answer1");

        Question expected = new Question("question1", "answer1");
        Question actual = javaQuestionService.remove(question);

        assertEquals(expected, actual);
        QuestionNotFoundException questionNotFoundException = assertThrows(QuestionNotFoundException.class, () -> {
            javaQuestionService.remove(notFoundQuestion);
        });
    }

    @Test
    void getAll() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();

        javaQuestionService.add("question1", "answer1");
        javaQuestionService.add("question2", "answer2");
        javaQuestionService.add("question3", "answer3");

        Set<Question> expected = new HashSet<>();
        expected.add(new Question("question1", "answer1"));
        expected.add(new Question("question2", "answer2"));
        expected.add(new Question("question3", "answer3"));

        assertEquals(expected, javaQuestionService.getAll());

        assertEquals(3, javaQuestionService.getAll().size());

    }

    @Test
    void getRandomQuestion() {

        JavaQuestionService javaQuestionService = new JavaQuestionService();

        javaQuestionService.add("question1", "answer1");
        javaQuestionService.add("question2", "answer2");
        javaQuestionService.add("question3", "answer3");


        Question randomQuestion = javaQuestionService.getRandomQuestion();

        assertNotNull(randomQuestion);
        assertTrue(javaQuestionService.getAll().contains(randomQuestion));

    }

    @Test
    void getRandomQuestionNull() {
        JavaQuestionService javaQuestionService = new JavaQuestionService();


        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () ->{
            javaQuestionService.getRandomQuestion();
        });
    }
};


