package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String urlImage;
    private String dateUpload;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    @Transient
    private MultipartFile imageUpload;
}
