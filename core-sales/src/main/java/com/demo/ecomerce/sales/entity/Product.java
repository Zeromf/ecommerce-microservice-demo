package com.demo.ecomerce.sales.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    private UUID productId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "category")
    private int category;
    @Column(name = "discount")
    private int discount;
    @Column(name = "imageUrl")
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryName;

    @OneToMany(mappedBy = "product")
    private List<SaleProduct> saleProducts;

    // Constructor sin ID (si quieres)
    public Product(String name, String description, Double price, Integer category, Integer discount, String imageUrl) {
        this.productId = UUID.randomUUID();  // Generar UUID manualmente
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.discount = discount;
        this.imageUrl = imageUrl;
    }
}