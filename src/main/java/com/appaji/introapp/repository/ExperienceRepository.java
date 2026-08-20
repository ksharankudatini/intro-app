package com.appaji.introapp.repository;

import com.appaji.introapp.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    Optional<Experience> findByCompanyName(String companyName);
}
