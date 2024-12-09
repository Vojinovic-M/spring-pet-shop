package com.example.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dogs")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "breed")
    private String breed;
    @Column(name = "age")
    private Integer age;
    @Column(name = "size")
    private Integer size;
    @Column(name = "origin")
    private String origin;
    @Column(name = "price")
    private Integer price;
    @Column(name = "image_url")
    private String imageUrl;
}
