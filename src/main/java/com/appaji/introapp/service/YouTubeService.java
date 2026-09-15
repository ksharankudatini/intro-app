package com.appaji.introapp.service;

import com.appaji.introapp.dto.YoutubeDto;
import com.appaji.introapp.entity.YouTube;
import com.appaji.introapp.mapper.YouTubeMapper;
import com.appaji.introapp.repository.YouTubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class YouTubeService {
    private final YouTubeRepository repo;
    private final YouTubeMapper mapper;


    public List<YoutubeDto> getYoutube() {
        return repo.findAll().stream().map(mapper::toYoutubeDto).toList();
    }

    public YoutubeDto createYoutube(YoutubeDto dto) {
        return mapper.toYoutubeDto(repo.save(mapper.toYouTube(dto)));
    }

    public YoutubeDto updateYoutube(String title, YoutubeDto dto) {
        YouTube video = repo.findByTitle(title).orElseThrow(() -> new RuntimeException("youTube Video name not found"));
        mapper.updateYoutube(dto, video);
        return mapper.toYoutubeDto(repo.save(video));
    }

    public void deleteYoutube(String title) {
        repo.delete(repo.findByTitle(title).orElseThrow(() -> new RuntimeException("youTube Video name not found")));
    }
}
