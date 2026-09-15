package com.appaji.introapp.dto;

import java.time.LocalDate;

public record ExperienceDto(
        String companyName,
        String client,
        String tech,
        LocalDate joiningDate,
        LocalDate lastWorkingDate) {
}
