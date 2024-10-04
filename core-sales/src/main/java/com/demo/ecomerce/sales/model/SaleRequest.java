package com.demo.ecomerce.sales.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SaleRequest {

    private List<SaleProductRequest> products = new ArrayList<>();
    private Double totalPayed;
}