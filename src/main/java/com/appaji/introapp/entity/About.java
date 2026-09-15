package com.appaji.introapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class About {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String bio;

    private String profileImageUrl;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String linkedInUrl;

    @Column(unique = true)
    private String gitHubUrl;

    @Column(unique = true)
    private String youtubeChannel;
}
