package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.Code;
import com.codegym.repository.CodeRepository;
import com.codegym.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeService implements ICrudService<Code> {
    @Autowired
    CodeRepository codeRepository;
    @Override
    public List<Code> findAll() {
        return codeRepository.findAll();
    }

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public void delete(Code code) {

    }

    @Override
    public Code findById(Long id) {
        return null;
    }

    @Override
    public Page getAll(Pageable pageable) {
        return null;
    }

    public List<Code> getAllByBookId(Long bookId,Integer limitRecord) {
        return codeRepository.getAllByBookId(bookId,limitRecord);
    }
}
