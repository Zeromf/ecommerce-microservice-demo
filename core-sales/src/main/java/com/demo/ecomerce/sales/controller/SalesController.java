package com.demo.ecomerce.sales.controller;

import com.demo.ecomerce.sales.entity.Product;
import com.demo.ecomerce.sales.model.SaleRequest;
import com.demo.ecomerce.sales.model.SaleResponse;
import com.demo.ecomerce.sales.service.ISaleService;
import com.demo.ecomerce.sales.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class SalesController {

    private final ISaleService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

//    @GetMapping("/sales/products")
//    public List<Product> getAllProducts() {
//        return salesService.fetchAllProducts();
//    }
//
//    @GetMapping("/sales/products/{id}")
//    public Product getProductById(@PathVariable Long id) {
//        return salesService.fetchProductById(id);
//    }

    @PostMapping("/sales/products")
    public ResponseEntity<?> createSale(@RequestBody SaleRequest request) {
            SaleResponse saleResponse = salesService.generateSale(request);
            return ResponseEntity.ok(saleResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable int id) {
        SaleResponse sale = salesService.getSaleById(id);
        return ResponseEntity.ok(sale);
    }

}


