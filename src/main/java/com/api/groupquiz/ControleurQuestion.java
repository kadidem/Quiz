package com.api.groupquiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControleurQuestion {
    @Autowired
    private ServiceQuestion serviceQuestion;

    @GetMapping("question")
    public List<Question> getAllQuestions(){
        return serviceQuestion.getAllQuestions();
    }


    @PostMapping("add")
    public String addQuestion(@RequestBody  Question question){
        return ServiceQuestion.addQuestion(question);
    }

}
