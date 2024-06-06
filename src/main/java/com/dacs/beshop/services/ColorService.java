package com.dacs.beshop.services;

import com.dacs.beshop.entities.Color;

import java.util.List;

public interface ColorService {
    List<Color> getAllColors();
    Color getColorById(Integer id);
}
