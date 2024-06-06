package com.dacs.beshop.mapper;

import com.dacs.beshop.dto.response.SizeResponseDto;
import com.dacs.beshop.entities.Size;

public class SizeMapper {
    public static SizeResponseDto toSizeResponseDto(Size size) {
        return SizeResponseDto.builder()
                .id(size.getId())
                .name(size.getName())
                .build();
    }
}
