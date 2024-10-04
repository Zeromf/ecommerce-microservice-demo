package com.demo.ecomerce.sales.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class SaleResponse {

    private int id;
    private double totalPay;
    private int totalQuantity;
    private double subtotal;
    private double totalDiscount;
    private double taxes;
    private LocalDateTime date;
    private List<SaleProductResponse> products = new ArrayList<>();


}