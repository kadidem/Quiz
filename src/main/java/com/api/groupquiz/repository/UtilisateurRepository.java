package com.api.groupquiz.repository;

import com.api.groupquiz.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur ,Long> {
}
