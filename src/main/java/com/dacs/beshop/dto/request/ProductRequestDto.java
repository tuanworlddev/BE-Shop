package com.dacs.beshop.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private String description;
    private Integer categoryId;
    private List<String> images;
    private List<ProductVariantRequestDto> variants;
}
