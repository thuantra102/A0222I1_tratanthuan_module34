package com.repository;

import com.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    @Query(value = "select i from ImageModel  i where i.idImage like :id")
    List<ImageModel> searchById(@Param("id") Integer id);
}