package com.example.imageofday.service.imp;

import com.example.imageofday.model.Comment;
import com.example.imageofday.repository.CommentRepository;
import com.example.imageofday.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICrudService<Comment> {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ImageService imageService;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public Comment findById(Long id) {
        return null;
    }

    @Override
    public Page getAll(Pageable pageable) {
        return null;
    }

    public Page findByImageId(Long id,Pageable pageable) {
        return commentRepository.findByImage(imageService.findById(id),pageable);
    }
}
