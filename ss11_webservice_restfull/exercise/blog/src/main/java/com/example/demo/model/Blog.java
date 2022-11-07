package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
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
    @JsonManagedReference
    private Category category;
    @Transient
    private MultipartFile imageUpload;
}
