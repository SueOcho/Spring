package com.springdata.data.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity

@Table(name="sale")
public class Sale {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne//FK (SIEMPRE SE USA EN LLAVE FORANEA ,ONETOMANY IRIA EN CUSTOMER SI QUIERO BIDIRECIONAL(ESTO SI TENEMOS MAESTRO DETALLE))
    @JoinColumn(name="id_customer",nullable = false,foreignKey = @ForeignKey(name="FK_sale_costumer")) //Foreignkey SE USA PARA DAR NOMBRE A LA RELACION,NO ES NECESARIO
    private Customer Customer;

    @ManyToOne
    @JoinColumn(name="id_user",nullable = false,foreignKey = @ForeignKey(name="FK_sale_user"))
    private User user;

    @Column(name="saleCode",nullable = false)
    private UUID saleCode;

    @Column(name="date",nullable = false)
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime date;

}
