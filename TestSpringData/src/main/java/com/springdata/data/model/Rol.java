package com.springdata.data.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="rol")
public class Rol {

    @Id
    private Integer idRol;

    @Column(name="name",length = 20)
    private String name;

    @Column(name="description",length = 50)
    private String description;
}
