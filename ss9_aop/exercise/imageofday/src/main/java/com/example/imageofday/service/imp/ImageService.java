package com.example.imageofday.service.imp;

import com.example.imageofday.model.Image;
import com.example.imageofday.repository.ImageRepository;
import com.example.imageofday.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements ICrudService<Image> {
    @Autowired
    ImageRepository imageRepository;
    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public void save(Image image) {

    }

    @Override
    public void delete(Image image) {

    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Page getAll(Pageable pageable) {
        return null;
    }
}
