package com.appaji.introapp.service;

import com.appaji.introapp.dto.ExperienceDto;
import com.appaji.introapp.entity.Experience;
import com.appaji.introapp.mapper.ExperienceMapper;
import com.appaji.introapp.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository repo;
    private final ExperienceMapper mapper;

    public List<ExperienceDto> getExperiences() {
        return repo.findAll().stream().sorted(Comparator.comparing(Experience::getJoiningDate)).map(mapper::toExperienceDto).toList();
    }

    public ExperienceDto createExperience(ExperienceDto dto) {
        mapper.toExperience(dto);
        return mapper.toExperienceDto(repo.save(mapper.toExperience(dto)));
    }

    public ExperienceDto updateExperience(String companyName, ExperienceDto dto) {
        Experience experience = repo.findByCompanyName(companyName).orElseThrow(() -> new RuntimeException("Company name not found"));
        mapper.updateExperience(dto, experience);
        return mapper.toExperienceDto(repo.save(experience));
    }

    public void deleteExperience(String companyName) {
        repo.delete(repo.findByCompanyName(companyName).orElseThrow(() -> new RuntimeException("Company name not found")));
    }
}
