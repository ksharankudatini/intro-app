package com.appaji.introapp.repository;

import com.appaji.introapp.entity.YouTube;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YouTubeRepository extends JpaRepository<YouTube, Integer> {
    Optional<YouTube> findByTitle(String title);
}