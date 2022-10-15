package com.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "blogList")
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String urlImage;
    private String dateUpload;
    @Transient
    private MultipartFile imageUpload;

    public BlogModel() {
    }

    public BlogModel(Long id, String name, String content, String urlImage, String dateUpload, MultipartFile imageUpload) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.urlImage = urlImage;
        this.dateUpload = dateUpload;
        this.imageUpload = imageUpload;
    }

    public MultipartFile getImageUpload() {
        return imageUpload;
    }

    public void setImageUpload(MultipartFile imageUpload) {
        this.imageUpload = imageUpload;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(String dateUpload) {
        this.dateUpload = dateUpload;
    }
}
