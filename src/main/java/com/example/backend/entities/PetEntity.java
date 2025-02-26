package com.example.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @Column(name = "origin_lat")
    private Double originLat;
    @Column(name = "origin_lng")
    private Double originLng;
    @Column(name = "price")
    private Integer price;
    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<OrderEntity> orders;
}
