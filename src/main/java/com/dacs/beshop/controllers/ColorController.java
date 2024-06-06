package com.dacs.beshop.controllers;

import com.dacs.beshop.dto.response.ColorResponseDto;
import com.dacs.beshop.mapper.ColorMapper;
import com.dacs.beshop.services.ColorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public List<ColorResponseDto> getAllColors() {
        return colorService.getAllColors().stream().map(ColorMapper::toColorResponseDto).toList();
    }
}
