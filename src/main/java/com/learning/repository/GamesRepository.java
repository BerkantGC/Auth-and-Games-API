package com.learning.repository;

import com.learning.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Games,Long> {
}
