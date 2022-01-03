package com.springdata.data.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="userType")
public class Usertype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",nullable = false,length = 70)
    private String name;

    @Column(name="description",nullable = false,length = 150)
    private String description;

}
