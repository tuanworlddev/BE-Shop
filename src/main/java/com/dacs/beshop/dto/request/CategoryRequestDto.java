package com.dacs.beshop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDto {
    @NotNull
    private String name;
    private String description;
    @NotNull
    private String image;
}
