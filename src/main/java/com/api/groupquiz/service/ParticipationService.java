package com.api.groupquiz.service;

import com.api.groupquiz.entity.Participation;
import com.api.groupquiz.repository.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipationService {
    @Autowired
    private ParticipationRepository participationRepository;

    public Participation createQuiz(Participation participation){
        return participationRepository.save(participation);
    }
    public List<Participation> getAllQuestions(){
        return participationRepository.findAll();
    }

    public Optional<Participation> getParticipationById(Long id){
        return participationRepository.findById(id);
    }

    public String editParticipation(Long id, int score){
        participationRepository.findById(id)
                .map(p ->{
                    p.setScore(score);
                    return participationRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Question non trouvé"));
        return "Modification éffectué";
    }
    public boolean deleQuestionById(Long id){
        participationRepository.deleteById(id);
        return true;
    }

    public Participation getParticipationByUserAndQuizId(Long userId, Long quizId) {
        return  participationRepository.findByUtilisateur_IdAndQuiz_Id(userId,quizId);
    }
}