package pro.sky.CoursePaperJavaCore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CoursePaperJavaCore.model.Question;
import pro.sky.CoursePaperJavaCore.service.ExaminerServiceImpl;
import pro.sky.CoursePaperJavaCore.service.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void test() {
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");

        when(javaQuestionService.getAll()).thenReturn(new HashSet<>(){{
            add(question1);
            add(question2);
            add(question3);
        }});
        when(javaQuestionService.getRandomQuestion()).thenReturn(question1, question2, question3);

        Collection<Question> questions = javaQuestionService.getAll();

        assertEquals(3, questions.size());

    }



}

