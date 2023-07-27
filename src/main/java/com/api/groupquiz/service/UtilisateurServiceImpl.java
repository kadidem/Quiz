package com.api.groupquiz.service;

import com.api.groupquiz.entity.Utilisateur;
import com.api.groupquiz.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository ;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> read() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur update(Long id, Utilisateur utilisateur) {
        return utilisateurRepository.findById(id)
                .map(p -> {
                    p.setPrenom_nom(utilisateur.getPrenom_nom());
                    p.setPassword(utilisateur.getPassword());
                    p.setEmail(utilisateur.getEmail());
                    return utilisateurRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("utilisateur non trouvé"));

    }


    public String delete(Long id) {
        utilisateurRepository.deleteById(id);
        return "utilisateur supprimé";

    }
    public Optional<Utilisateur> readById(Long id) {
        return utilisateurRepository.findById(id);
    }

}
