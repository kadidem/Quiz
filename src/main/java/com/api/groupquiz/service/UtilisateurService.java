package com.api.groupquiz.service;

import com.api.groupquiz.entity.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur create(Utilisateur utilisateur);
    List<Utilisateur> read();
    Utilisateur update(Long id , Utilisateur utilisateur);
    String delete(Long id);
    Optional<Utilisateur> read1(Long id);
}
