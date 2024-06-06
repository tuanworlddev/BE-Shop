package com.dacs.beshop.services;

import com.dacs.beshop.entities.Size;

import java.util.List;

public interface SizeService {
    List<Size> getAllSizes();
    Size getSizeById(Integer id);
}
