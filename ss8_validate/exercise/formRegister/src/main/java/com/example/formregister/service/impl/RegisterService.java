package com.example.formregister.service.impl;

import com.example.formregister.model.Register;
import com.example.formregister.repository.RegisterRepository;
import com.example.formregister.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements ICrudService<Register> {
    @Autowired
    RegisterRepository registerRepository;

    @Override
    public List<Register> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public void save(Register register) {
        registerRepository.save(register);
    }

    @Override
    public void delete(Register register) {

    }

    @Override
    public Register findById(Long id) {
        return null;
    }

    @Override
    public Page getAll(Pageable pageable) {
        return null;
    }
}
