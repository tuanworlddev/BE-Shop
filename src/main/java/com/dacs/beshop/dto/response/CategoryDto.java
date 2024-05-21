package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {
    private Integer id;
    private String name;
    private String image;
}
