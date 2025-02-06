package pro.sky.CoursePaperJavaCore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CoursePaperJavaCore.model.Question;
import pro.sky.CoursePaperJavaCore.service.JavaQuestionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    void add() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");

        List<Question> questions = Arrays.asList(question1, question2, question3);

        when(javaQuestionService.getAll()).thenReturn(questions);

        assertNotNull(javaQuestionService.getAll());
        assertEquals(3, javaQuestionService.getAll().size());


    }


}
