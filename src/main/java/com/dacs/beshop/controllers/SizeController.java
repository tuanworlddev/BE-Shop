package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.response.SizeResponseDto;
import com.dacs.beshop.mapper.SizeMapper;
import com.dacs.beshop.services.SizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {
    private final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping
    public List<SizeResponseDto> getAll() {
        return  sizeService.getAllSizes().stream().map(SizeMapper::toSizeResponseDto).toList();
    }
}
