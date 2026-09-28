package com.appaji.introapp.controller;


import com.appaji.introapp.dto.AboutDto;
import com.appaji.introapp.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AboutController {
    private final AboutService service;

    @GetMapping("/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {

        Path path = Paths.get("uploads").resolve(filename);
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

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
    public ResponseEntity<Void> deleteAbout(@RequestParam String email) {
        service.deleteAbout(email);
        return ResponseEntity.noContent().build();
    }
}
