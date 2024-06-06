package com.dacs.beshop.services.impl;

import com.dacs.beshop.entities.Size;
import com.dacs.beshop.exceptions.NotFoundException;
import com.dacs.beshop.repositories.SizeRepository;
import com.dacs.beshop.services.SizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {
    private final SizeRepository sizeRepository;

    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(Integer id) {
        return sizeRepository.findById(id).orElseThrow(() -> new NotFoundException("Size Not Found"));
    }
}
