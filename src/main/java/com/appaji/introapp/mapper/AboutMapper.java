package com.appaji.introapp.mapper;


import com.appaji.introapp.dto.AboutDto;
import com.appaji.introapp.entity.About;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AboutMapper {
    AboutDto toAboutDto(About about);

    About toAbout(AboutDto dto);

    void updateAbout(AboutDto dto, @MappingTarget About about);
}
