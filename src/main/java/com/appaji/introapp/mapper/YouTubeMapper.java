package com.appaji.introapp.mapper;

import com.appaji.introapp.dto.YoutubeDto;
import com.appaji.introapp.entity.YouTube;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface YouTubeMapper {
    YouTube toYouTube(YoutubeDto dto);

    YoutubeDto toYoutubeDto(YouTube youTube);

    void updateYoutube(YoutubeDto dto, @MappingTarget YouTube youTube);
}
