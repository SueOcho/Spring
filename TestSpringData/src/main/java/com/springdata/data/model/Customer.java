package com.springdata.data.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity //(name="x") "from x where x.idCustomer=1"  SI NO SE PONE NOMBRE TOMA POR DEFENTO EL NOMBRE DE LA TABLA
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="dni",nullable = false,length = 8)
    private String dni;

    @Column(name="userName",nullable = false,length = 70)
    private String userName;

    @Column(name="lastName",nullable = false,length = 70)
    private String lastName;

    @Column(name="password",nullable = false,length = 55)
    private String password;

    @Column(name="email",nullable = false,length = 55)
    private String email;

    @Column(name="address",length = 150)
    private String address ;

    @Column(name="phoneNumber",length = 9)
    private String phoneNumber;

    @Column(name="birthDate")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
}
