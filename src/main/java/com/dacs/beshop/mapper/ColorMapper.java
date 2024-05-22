package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.ColorResponseDto;
import com.dacs.beshop.entities.Color;

public class ColorMapper {
    public static ColorResponseDto toColorResponseDto(Color color) {
        return ColorResponseDto.builder()
                .id(color.getId())
                .name(color.getName())
                .value(color.getValue())
                .build();
    }
}
