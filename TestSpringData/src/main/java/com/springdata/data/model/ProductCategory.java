package com.springdata.data.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMenu;

    @Column(name="name",length = 20)
    private String name;

    @Column(name="url",length = 50)
    private String url;
}
