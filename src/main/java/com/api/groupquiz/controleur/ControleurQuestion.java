package com.api.groupquiz.controleur;

import com.api.groupquiz.entity.Question;
import com.api.groupquiz.entity.Utilisateur;
import com.api.groupquiz.service.ServiceQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class ControleurQuestion {
    @Autowired
    private ServiceQuestion serviceQuestion;

    @GetMapping("read")
    public List<Question> getAllQuestions(){
        return serviceQuestion.getAllQuestions();
    }


    @PostMapping("add")
        public String addQuestion(@RequestBody  Question question){
        return serviceQuestion.addQuestion(question);
    }
    @GetMapping("read/{id}")
    public Optional <Question> getQuestionById(@PathVariable Long id){
        return serviceQuestion.getQuestionById(id);

    }
    @DeleteMapping("delete/{id}")
    public String deleteQuestionById(@PathVariable Long id){
        return serviceQuestion.deleteQuestionById(id);

    }

    @PutMapping("update/{id}")
    public Question update(@PathVariable Long id ,@RequestBody  Question question){
        return serviceQuestion.update(id, question);
    }

}
