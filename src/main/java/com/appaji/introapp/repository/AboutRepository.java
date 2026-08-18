package com.appaji.introapp.repository;


import com.appaji.introapp.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AboutRepository extends JpaRepository<About, Integer> {
    Optional<About> findByEmail(String email);
}
