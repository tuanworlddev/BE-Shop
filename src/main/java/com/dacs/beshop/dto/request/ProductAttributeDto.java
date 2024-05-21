package com.dacs.beshop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAttributeDto {
    @NotNull
    private String type;
    @NotNull
    private String value;
}
