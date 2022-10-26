package com.example.imageofday.repository;

import com.example.imageofday.model.Comment;
import com.example.imageofday.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
//    @Query(value = "select* from comment where image_id = :id order by ",nativeQuery = true)
//    Page<Comment> findByImageId(@Param("id") Long id, Pageable pageable);
    Page findByImage(Image image,Pageable pageable);
}
