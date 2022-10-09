package com.model;

import javax.persistence.*;

@Entity
@Table
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private Integer pageSize;
    private Boolean spam;
    private String signature;

    public EmailModel() {
    }

    public EmailModel(Long id, String language, Integer pageSize, Boolean spam, String signature) {
        this.id = id;
        this.language = language;
        this.pageSize = pageSize;
        this.spam = spam;
        this.signature = signature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSpam() {
        return spam;
    }

    public void setSpam(Boolean spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
