package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Float sale;
    private String image;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ProductAttributeDto> attributes;
}
