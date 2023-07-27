package com.api.groupquiz.controleur;


import com.api.groupquiz.entity.Participation;
import com.api.groupquiz.entity.Quiz;
import com.api.groupquiz.entity.Reponse;
import com.api.groupquiz.entity.Utilisateur;
import com.api.groupquiz.service.ParticipationService;
import com.api.groupquiz.service.ReponseService;
import com.api.groupquiz.service.UtilisateurService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("participation")
@RestController
public class ParticipationController {

    private final ParticipationService participationService;
    private final UtilisateurService utilisateurService;

    private final QuestionService questionService;

    private final ReponseService reponseService;


    @Autowired
    public ParticipationController(ParticipationService participationService,UtilisateurService utilisateurService,
                                    QuestionService questionService,ReponseService reponseService){
        this.participationService = participationService;
        this.utilisateurService = utilisateurService;
        this.questionService = questionService;
        this.reponseService = reponseService;
    }

    @GetMapping("/{userId}/{quizId}/init")
    public Participation init(@PathVariable Long userId, @PathVariable Long quizId){
        Participation participation = participationService.getParticipationByUserAndQuizId(userId,quizId);
        if(participation != null){
            participationService.editParticipation(participation.getId(), 0);
                participation.setScore(0);
            return participation;
        }
        return  new Participation();
    }
    @GetMapping("/{userId}/{quizId}/{questionId}")
    public ApiResponse game(@PathVariable Long userId, @PathVariable Long quizId, @PathVariable Long questionId,
                            @RequestParam Long checkedReponseID){
            Utilisateur utilisateur = utilisateurService.readById(userId).get();
            Question quest = questionService.findQuestionById(questionId);
            Quiz quiz = quest.getQuiz();

           Long quizzId = quiz.getId();
           boolean checkResponse = reponseService.readById(checkedReponseID).get().isIscorrect();
           Participation participation = participationService.getParticipationByUserAndQuizId(userId,quizId);
           if(participation == null){
                participation = new Participation();
                participation.setScore(0);
                participation.setQuiz(quiz);
                participation.setUtilisateur(utilisateur);
               participationService.createQuiz(participation);
           }
           List <Reponse> responses = reponseService.getAllResponsesByQuizId(quizId);
           if(checkResponse){
               participationService.editParticipation(participation.getId(), participation.getScore()+quest.getPoints());
               return new ApiResponse(200,"Mr "+utilisateur.getPrenom_nom()+" Vous avez choici la bonne reponse votre score est de "+(participation.getScore()+quest.getPoints()),null);
           }else
               return new ApiResponse(200," Oups Mr "+utilisateur.getPrenom_nom()+" Vous avez choici la nauvaise reponse "+checkedReponseID,responses);

    }
    @GetMapping("{id}")
    public Participation getQuestionById(@PathVariable Long id){
        Optional<Participation> question = participationService.getParticipationById(id);
        return (Participation) question.orElse(null);
    }
    @PutMapping("update/{id}")
    public String updateQuiz(@PathVariable Long id,@RequestBody int score){
        Optional<String> participation1 = Optional.ofNullable(participationService.editParticipation(id, score));
        return (String) participation1.orElse(null);
    }
    @DeleteMapping("delete/{id}")
    public  Boolean deleteQuiz(@PathVariable Long id){
        return participationService.deleQuestionById(id);
    }

    @PostMapping("/create")
    public Participation create(@RequestBody Participation participation){
        return participationService.createQuiz(participation);
    }
}