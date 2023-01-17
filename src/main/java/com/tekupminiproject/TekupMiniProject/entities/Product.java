package com.tekupminiproject.TekupMiniProject.entities;

import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name ="category_id",referencedColumnName = "category_id")
    private Category category;
    private double price;
    private double dimension;
    private String location;
    private String description;
    private String contact ;
    private String imageName;
}
