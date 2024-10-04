package org.accenture.ecommerce_demo.model;

import lombok.Data;
import org.accenture.ecommerce_demo.entity.SaleProduct;

import java.util.UUID;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private int discount;
    private String imageUrl;
    private int category;
    private int saleProductId;
}