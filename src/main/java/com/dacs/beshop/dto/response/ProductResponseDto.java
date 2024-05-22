package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponseDto {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private List<ProductImageResponseDto> images;
    private List<ProductVariantResponseDto> variants;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
