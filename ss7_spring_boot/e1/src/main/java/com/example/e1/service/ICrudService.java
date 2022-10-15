package com.example.e1.service;

import java.util.List;

public interface ICrudService<E> {
    List<E> findAll();
    void save(E e);
    void delete(E e);
    E findById(Long id);
}