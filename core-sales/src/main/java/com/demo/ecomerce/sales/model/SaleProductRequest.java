package com.demo.ecomerce.sales.model;

import lombok.Data;

import java.util.UUID;

@Data
public class SaleProductRequest {

    private UUID productId;
    private int quantity;

}