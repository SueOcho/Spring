package com.springdata.data.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min=8,message = "dni debe tener 8 caracteres")
    @Column(name="dni",nullable = false,length = 8)
    private String dni;

    @Size(min=3,message = "usuario debe tener minimo 3 caracteres")
    @Column(name="username",nullable = false,length = 70)
    private String username;

    @Size(min=3,message = "apellido debe tener minimo 3 caracteres")
    @Column(name="lastname",nullable = false,length = 70)
    private String lastname;

    @Size(min=6,message = "contraseña debe tener minimo 6 caracteres")
    @Column(name="password",nullable = false,length = 55)
    private String password;

    @Column(name="enabled",nullable = false)
    private boolean enabled;

    @Email
    //Patter(regex) para un expresion regular, averiguar
    @Column(name="email",nullable = false,length = 55,unique=true)
    private String email;

    @Size(min=3,message = "La dirección debe tener minimo 3 caracteres")
    @Column(name="address",length = 150)
    private String address ;

    @Size(min=6,message = "El telefono debe tener  9 caracteres")
    @Column(name="phoneNumber",length = 9)
    private String phoneNumber;

    @Column(name="birthDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name="id_usertype",nullable = false,foreignKey = @ForeignKey(name="FK_user_usertype"))
    private Usertype usertype;


}
