package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page findAllByNameContaining(Pageable pageable, String name);

    @Query(nativeQuery = true, value = "select * from blog b where b.id_category = :id")
    List<Blog> findAllByCategory(@Param("id") Long id );
    @Query(nativeQuery = true, value = "select content from blog b where b.id=  :id")
    String selectContent(@Param("id") Long id );
    List<Blog> findAllByNameContaining(String name);
}
