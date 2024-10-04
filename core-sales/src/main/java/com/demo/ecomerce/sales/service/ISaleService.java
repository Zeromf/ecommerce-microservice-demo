package com.demo.ecomerce.sales.service;

import com.demo.ecomerce.sales.entity.Sale;
import com.demo.ecomerce.sales.model.SaleRequest;
import com.demo.ecomerce.sales.model.SaleResponse;

import java.util.List;

public interface ISaleService {

    SaleResponse generateSale(SaleRequest request);

    void calculateSale(SaleRequest request, Sale sale, List<String> errors);

    //List<SaleGetResponse> getSales(LocalDateTime from, Optional<LocalDateTime> to);
    SaleResponse getSaleById(int id);
}
