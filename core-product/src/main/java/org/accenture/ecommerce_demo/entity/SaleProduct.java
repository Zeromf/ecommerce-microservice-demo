package org.accenture.ecommerce_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale_product")
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shoppingCartId;

    private int sale;

    private UUID product;

    private int quantity;

    private BigDecimal price;

    private int discount;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale saleName;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productName;
}