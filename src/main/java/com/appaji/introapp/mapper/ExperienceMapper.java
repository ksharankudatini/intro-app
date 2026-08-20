package com.appaji.introapp.mapper;

import com.appaji.introapp.dto.ExperienceDto;
import com.appaji.introapp.entity.Experience;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExperienceMapper {
    Experience toExperience(ExperienceDto dto);

    ExperienceDto toExperienceDto(Experience entity);

    void updateExperience(ExperienceDto dto, @MappingTarget Experience entity);
}
