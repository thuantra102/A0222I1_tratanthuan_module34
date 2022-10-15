package com.service;

import com.model.ImageModel;
import com.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ImageService implements IImageService{
    @Autowired
    ImageRepository imageRepository;


    @Override
    public List<ImageModel> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public List<ImageModel> findByName(String name) {
        return null;
    }

    @Override
    public void save(ImageModel imageModel) {
        imageRepository.save(imageModel);
    }

    @Override
    public void delete(ImageModel imageModel) {

    }

    @Override
    public List<ImageModel> findById(Integer id) {
//        return imageRepository.findAllById(Collections.singleton(id));
        return imageRepository.searchById(id);
    }
}
