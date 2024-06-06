package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.response.ResponseDto;
import com.dacs.beshop.services.ProductVariantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {
    private final ProductVariantService productVariantService;

    public ProductVariantController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        productVariantService.deleteProductVariant(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.value(), "Deleted product variant successfully"));
    }
}
