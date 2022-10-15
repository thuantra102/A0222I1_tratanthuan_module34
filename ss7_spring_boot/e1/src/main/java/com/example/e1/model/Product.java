package com.example.e1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private String manufacture;
    @ManyToOne
    @JoinColumn( name = "id_category")
    private Category category;


}
