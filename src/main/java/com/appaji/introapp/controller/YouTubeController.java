package com.appaji.introapp.controller;


import com.appaji.introapp.dto.YoutubeDto;
import com.appaji.introapp.service.YouTubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class YouTubeController {
    private final YouTubeService service;

    @GetMapping("/youtube")
    public ResponseEntity<List<YoutubeDto>> getYoutube() {
        return ResponseEntity.ok(service.getYoutube());
    }

    @PostMapping("/youtube")
    public ResponseEntity<YoutubeDto> createYoutube(@RequestBody YoutubeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createYoutube(dto));
    }

    @PatchMapping("/youtube")
    public ResponseEntity<YoutubeDto> updateYoutube(@RequestParam String title, @RequestBody YoutubeDto dto) {
        return ResponseEntity.ok(service.updateYoutube(title, dto));
    }

    @DeleteMapping("/youtube")
    public ResponseEntity<Void> deleteYoutube(@RequestParam String title) {
        service.deleteYoutube(title);
        return ResponseEntity.noContent().build();
    }
}
