package org.accenture.ecommerce_demo.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductResponse {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private int discount;
    private String imageUrl;
}