package com.codegym.service.impl;

import com.codegym.model.Status;
import com.codegym.repository.StatusRepository;
import com.codegym.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class StatusService implements ICrudService<Status> {
    @Autowired
    StatusRepository statusRepository;
    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public void save(Status status) {

    }

    @Override
    public void delete(Status status) {

    }

    @Override
    public Status findById(Long id) {
        return null;
    }

    @Override
    public Page getAll(Pageable pageable) {
        return null;
    }
}
