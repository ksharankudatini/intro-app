package com.appaji.introapp.controller;


import com.appaji.introapp.dto.AboutDto;
import com.appaji.introapp.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AboutController {
    private final AboutService service;

    @GetMapping("/about")
    public ResponseEntity<AboutDto> getAbout() {
        return ResponseEntity.ok(service.getAbout());
    }

    @PostMapping("/about")
    public ResponseEntity<AboutDto> createAbout(@RequestBody AboutDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAbout(dto));
    }

    @PatchMapping("/about")
    public ResponseEntity<AboutDto> updateAbout(@RequestParam String email, @RequestBody AboutDto dto) {
        return ResponseEntity.ok(service.updateAbout(email, dto));
    }

    @DeleteMapping("/about")
    public ResponseEntity<AboutDto> deleteAbout(@RequestParam String email) {
        service.deleteAbout(email);
        return ResponseEntity.noContent().build();
    }
}
