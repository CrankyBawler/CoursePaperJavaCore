package pro.sky.CoursePaperJavaCore.Controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.CoursePaperJavaCore.model.Question;
import pro.sky.CoursePaperJavaCore.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(Question question) {
        return questionService.remove(question);
    }

    @GetMapping("/getAll")
    public Collection<Question> getAll() {

        return questionService.getAll();
    }
}