package com.appaji.introapp.config;

import com.appaji.introapp.entity.About;
import com.appaji.introapp.entity.Experience;
import com.appaji.introapp.entity.YouTube;
import com.appaji.introapp.repository.AboutRepository;
import com.appaji.introapp.repository.ExperienceRepository;
import com.appaji.introapp.repository.YouTubeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final AboutRepository aboutRepo;
    private final ExperienceRepository experienceRepo;
    private final YouTubeRepository youTubeRepo;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            if (aboutRepo.count() == 0) {
                About about = new About();
                about.setName("Appaji K");
                about.setBio("Java Full Stack Developer & Content Creator");
                about.setProfileImageUrl("https://example.com/profile.jpg");
                about.setEmail("ksharankudatini@gmail.com");
                about.setLinkedInUrl("https://www.linkedin.com/in/ksharanbasava/");
                about.setGitHubUrl("https://github.com/ksharankudatini/intro-app");
                about.setYoutubeChannel("https://www.youtube.com/@appajikvlogs");
                aboutRepo.save(about);
            }
            if (experienceRepo.count() == 0) {
                Experience experience = new Experience();
                experience.setCompanyName("Test Yantra");
                experience.setTech("Java, Springboot, MySql");
                experience.setJoiningDate(LocalDate.of(2021, Month.FEBRUARY, 24));
                experience.setLastWorkingDate(LocalDate.of(2021, Month.AUGUST, 22));
                experienceRepo.save(experience);
            }
            if (youTubeRepo.count() == 0) {
                YouTube youTube = new YouTube();
                youTube.setTitle("Apartment Terrace View");
                youTube.setUrl("https://www.youtube.com/watch?v=hbto1C-q2Do&t=126s");
                youTube.setDescription("In this video I have shown my Apartment terrace view towards nature in " +
                        "all directions and spoke few words about My flat MDVR SV SHELTERS.");
                youTubeRepo.save(youTube);
            }
        };
    }
}