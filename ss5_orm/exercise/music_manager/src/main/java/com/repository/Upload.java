package com.repository;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
    String id;
    String publicId;
    MultipartFile multipartFile;
    String typeFile;

    public Upload(String id, String publicId, MultipartFile multipartFile, String typeFile) {
        this.id = id;
        this.publicId = publicId;
        this.multipartFile = multipartFile;
        this.typeFile = typeFile;
    }

    public Upload() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }
}
