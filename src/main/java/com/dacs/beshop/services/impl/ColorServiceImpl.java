package com.dacs.beshop.services.impl;

import com.dacs.beshop.entities.Color;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.ColorRepository;
import com.dacs.beshop.services.ColorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColorById(Integer id) {
        return colorRepository.findById(id).orElseThrow(() -> new NotFoundException("No color found with id: " + id));
    }
}
