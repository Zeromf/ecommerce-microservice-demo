package com.demo.ecomerce.sales.client;

import com.demo.ecomerce.sales.entity.Product;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "core-product")
public interface CoreClient {
    @GetMapping("/products")
    List<Product> getProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") Long id);


}
