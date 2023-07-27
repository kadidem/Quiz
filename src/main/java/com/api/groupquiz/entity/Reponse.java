package com.api.groupquiz.entity;

import jakarta.persistence.*;

public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String libelle;
   // @ManyToOne
    //@JoinColumn(name = "question_id")
   // private Question question;
}
