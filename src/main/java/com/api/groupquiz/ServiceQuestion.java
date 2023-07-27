package com.api.groupquiz;

import com.api.groupquiz.RepositoryQuestion;
import com.api.groupquiz.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceQuestion {

    @Autowired
    private RepositoryQuestion repositoryQuestion;



    public List <Question> getAllQuestions(){

        return repositoryQuestion.findAll();
    }
    public String addQuestion(Question question) {
        repositoryQuestion.save(question);
        return "Question enregistrée avec succès";
    }
}


