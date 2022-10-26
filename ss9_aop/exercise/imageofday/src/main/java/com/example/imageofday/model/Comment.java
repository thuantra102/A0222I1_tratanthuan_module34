package com.example.imageofday.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String starts;
    private String feedBack;
    @ManyToOne(targetEntity = Image.class)
    private Image image;



}
