package com.appaji.introapp.dto;

public record AboutDto(
        String name,
        String bio,
        String profileImageUrl,
        String email,
        String linkedInUrl,
        String gitHubUrl,
        String youtubeChannel
) {
}