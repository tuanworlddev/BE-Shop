package com.dacs.beshop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {
    @NotNull
    private Integer variantId;

    @NotNull
    private Integer quantity;
}
