package com.springdata.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ProductSale")
public class ProductSale {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_product",nullable = false,foreignKey = @ForeignKey(name="FK_ProductSale_product"))
    private Product product;

    @ManyToOne
    @JoinColumn(name="id_saleDetail",nullable = false,foreignKey = @ForeignKey(name="FK_productSale_saleDetail"))
    private SaleDetail saleDetail;

    @Column(name="price",nullable = false)
    private Double price;

    @Column(name="amount",nullable = false)
    private Integer amount;

    @Column(name="totalPrice",nullable = false)
    private Double totalPrice;
}
