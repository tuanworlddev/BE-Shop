package com.dacs.beshop.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProductAttributeDto {
    private String type;
    private String value;
}
