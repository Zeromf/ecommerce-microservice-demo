package org.accenture.ecommerce_demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "core-sales",url = "http://localhost:8060/core_sales")
public interface SaleClient {
    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleById(@PathVariable int id);
}
