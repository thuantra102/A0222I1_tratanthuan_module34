package com.service;

import com.model.Product;

import java.util.List;
import java.util.Optional;

public interface ICrudService<E> {
    List<E> findAll();
    List<E> findByName(String name);
    void save(E e);
    void delete(E e);
    Optional<E> findById(Long id);
}
