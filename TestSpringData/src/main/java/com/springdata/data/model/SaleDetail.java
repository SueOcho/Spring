package com.springdata.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="saleDetail")
public class SaleDetail {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_sale",nullable = false,foreignKey = @ForeignKey(name="FK_saleDetail_sail"))
    private Sale sale;

    @Column(name="amount",nullable = false)
    private Integer amount;

    @Column(name="totalPrice",nullable = false)
    private Double totalPrice;

    //Solo afecta a nivel lógico
    @OneToMany(mappedBy = "saleDetail",cascade = {CascadeType.ALL},orphanRemoval = true)//El orphanRemoval nos va permitir eliminar detalles
    private List<ProductSale> productSales;

}
