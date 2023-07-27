package com.api.groupquiz.repository;

import com.yougo.APIRESTTP.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

    List<Quiz> findByTitreContaining(String titre);

    List<Quiz> findByUtilisateur_id(Long id);
}
