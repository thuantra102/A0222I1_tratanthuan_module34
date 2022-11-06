package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.Code;
import com.codegym.model.Status;
import com.codegym.repository.BookRepository;
import com.codegym.repository.CodeRepository;
import com.codegym.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements ICrudService<Book> {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CodeRepository codeRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        Random random = new Random();
        Status status = new Status(2L);
        bookRepository.save(book);
        for (int i = 0; i <book.getQuantity() ; i++) {
            int randomCode = 10000 +  random.nextInt(90000);
            codeRepository.save(new Code(randomCode,book,status));
        }
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Page getAll(Pageable pageable) {
        return null;
    }
}
