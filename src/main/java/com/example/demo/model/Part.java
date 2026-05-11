package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String modelName;
    private Integer price;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}