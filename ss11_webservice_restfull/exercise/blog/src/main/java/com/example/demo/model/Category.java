package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Blog> blogs;

    public Category() {
    }

    public Category(Long id, String category) {
        this.id = id;
        this.category = category;
    }

    public Category(Long id) {
        this.id = id;
    }
}
