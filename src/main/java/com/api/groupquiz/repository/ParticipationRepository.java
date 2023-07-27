package com.api.groupquiz.repository;

import com.api.groupquiz.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation,Long> {
    Participation findByUtilisateur_IdAndQuiz_Id(Long userId,Long quizId);
}
