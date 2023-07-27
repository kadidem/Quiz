package com.api.groupquiz.service;

import com.api.groupquiz.entity.Reponse;
import com.api.groupquiz.repository.ReponseRepository;
import com.api.groupquiz.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReponseServiceImpl implements UtilisateurRepository.ReponseService {
    private final ReponseRepository reponseRepository;
    public ReponseServiceImpl(ReponseRepository reponseRepository) {
        this.reponseRepository = reponseRepository;
    }
    @Override
    public Reponse create(Reponse reponse) {

        return (Reponse) reponseRepository.save(reponse);
    }

    @Override
    public List<Reponse> read() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse update(Long id, Reponse reponse) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Reponse> readById(Long id) {
        return Optional.empty();
    }
}
