package com.example.imageofday.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlImg;
    @OneToMany(mappedBy = "image")
    private List<Comment> comments;

    public Image(Long id, String urlImg) {
        this.id = id;
        this.urlImg = urlImg;
    }

    public Image() {

    }
}
