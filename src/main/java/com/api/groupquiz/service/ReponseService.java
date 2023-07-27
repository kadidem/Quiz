package com.api.groupquiz.service;

import com.api.groupquiz.entity.Reponse;

import java.util.List;
import java.util.Optional;

public interface ReponseService {
    Reponse create(Reponse reponse);
    List<Reponse> read();
    Reponse update(Long id , Reponse reponse);
    String delete(Long id);
    Optional<Reponse> readById(Long id);
}
