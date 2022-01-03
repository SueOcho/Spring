package com.springdata.data.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name="name",nullable = false,length = 50)
    private String name;

    @Column(name="price",nullable = false)
    private Double price;

    @Column(name="stock",nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name="id_productCategory",nullable = false,foreignKey = @ForeignKey(name="FK_product_productCategory"))
    private ProductCategory productCategory;

}
