package com.appaji.introapp.controller;

import com.appaji.introapp.dto.ExperienceDto;
import com.appaji.introapp.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ExperienceController {
    private final ExperienceService service;

    @GetMapping("/experience")
    public ResponseEntity<List<ExperienceDto>> getExperiences() {
        return ResponseEntity.ok(service.getExperiences());
    }

    @PostMapping("/experience")
    public ResponseEntity<ExperienceDto> createExperience(@RequestBody ExperienceDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createExperience(dto));
    }

    @PatchMapping("/experience")
    public ResponseEntity<ExperienceDto> updateExperience(@RequestParam String companyName, @RequestBody ExperienceDto dto) {
        return ResponseEntity.ok(service.updateExperience(companyName, dto));
    }

    @DeleteMapping("/experience")
    public ResponseEntity<Void> deleteExperience(@RequestParam String companyName) {
        service.deleteExperience(companyName);
        return ResponseEntity.noContent().build();
    }
}
