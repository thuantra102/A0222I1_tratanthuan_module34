package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table
@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;
    @ManyToOne(targetEntity = Book.class)
//    @JsonManagedReference
    private Book book;
    @ManyToOne(targetEntity = Status.class)
    @JsonBackReference
    private Status status;

    public Code(Integer code, Book book, Status status) {
        this.code = code;
        this.book = book;
        this.status = status;
    }

    public Code() {
    }
}
