package com.api.groupquiz.repository;

import com.api.groupquiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryQuestion extends JpaRepository<Question, Long> {
}
