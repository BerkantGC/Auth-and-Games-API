package com.learning.repository;

import com.learning.model.Sellers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellersRepository extends JpaRepository<Sellers, Long> {
}
