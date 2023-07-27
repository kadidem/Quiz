package com.api.groupquiz.service;

import com.api.groupquiz.entity.Question;
import com.api.groupquiz.entity.Utilisateur;
import com.api.groupquiz.repository.RepositoryQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Question> getQuestionById(Long id) {
        return repositoryQuestion.findById(id);
    }

    public String deleteQuestionById(Long id) {
         repositoryQuestion.deleteById(id);
        return "Question Supprimée";
    }

    public Question update(Long id ,Question question ) {
        return repositoryQuestion.findById(id)
                .map(p -> {
               p.setLibelle(question.getLibelle());
               p.setPoint(question.getPoint());
               return repositoryQuestion.save(p);

           }).orElseThrow(() -> new RuntimeException("Question non trouvée"));
    }
}


