package com.dacs.beshop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
public class CartRequestDto {
    @NotNull
    private Integer variantId;

    @NotNull
    private Integer quantity;
}
