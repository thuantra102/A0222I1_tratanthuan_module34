package com.service;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository repository;
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByNameContains(name);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }
    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }


}
