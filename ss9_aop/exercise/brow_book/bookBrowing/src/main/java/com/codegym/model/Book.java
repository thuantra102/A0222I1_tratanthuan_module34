package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String author;
    private Integer quantity;
    @OneToMany(mappedBy = "book")
//    @JsonBackReference
    private List<Code> codeList;

    public Book() {
    }

    public Book(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
