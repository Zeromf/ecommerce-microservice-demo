package org.accenture.ecommerce_demo.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category categoryName;

//    @OneToMany(mappedBy = "product")
//    private List<SaleProduct> saleProducts;
}