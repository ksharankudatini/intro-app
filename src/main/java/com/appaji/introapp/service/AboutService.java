package com.appaji.introapp.service;

import com.appaji.introapp.dto.AboutDto;
import com.appaji.introapp.entity.About;
import com.appaji.introapp.mapper.AboutMapper;
import com.appaji.introapp.repository.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutRepository repo;
    private final AboutMapper mapper;

    public AboutDto getAbout() {
        return mapper.toAboutDto(repo.findAll().stream().findFirst().orElseThrow(() -> new RuntimeException("No About data found")));
    }

    public AboutDto createAbout(AboutDto dto) {
        return mapper.toAboutDto(repo.save(mapper.toAbout(dto)));
    }

    public AboutDto updateAbout(String email, AboutDto dto) {
        About about = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("No Data Found"));
        mapper.updateAbout(dto, about);
        return mapper.toAboutDto(repo.save(about));
    }

    public void deleteAbout(String email) {
        repo.delete(repo.findByEmail(email).orElseThrow(() -> new RuntimeException("No Data Found")));
    }
}
