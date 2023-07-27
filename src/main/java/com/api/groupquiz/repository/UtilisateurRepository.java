package com.api.groupquiz.repository;

import com.api.groupquiz.entity.Reponse;
import com.api.groupquiz.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur ,Long> {
    Utilisateur findByEmail(String email);

    interface ReponseService {
        Reponse create(Reponse reponse);
        List<Reponse> read();
        Reponse update(Long id , Reponse reponse);
        String delete(Long id);
        Optional<Reponse> readById(Long id);
    }
}
