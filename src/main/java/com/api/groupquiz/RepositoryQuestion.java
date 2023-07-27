package com.api.groupquiz;

import com.api.groupquiz.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryQuestion extends JpaRepository<Question, Long> {
}
