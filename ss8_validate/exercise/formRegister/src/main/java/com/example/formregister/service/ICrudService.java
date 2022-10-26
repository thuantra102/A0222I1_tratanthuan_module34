package com.example.formregister.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICrudService<E> {
    List<E> findAll();
    void save(E e);
    void delete(E e);
    E findById(Long id);
    Page getAll(Pageable pageable);
}
