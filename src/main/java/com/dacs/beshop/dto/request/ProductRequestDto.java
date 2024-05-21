package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer categoryId;
    private String image;
    private Float sale;
    private Integer quantity;
    private List<ProductAttributeRequestDto> attributes;
}
