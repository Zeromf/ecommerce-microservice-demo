package org.accenture.ecommerce_demo.service;

import org.accenture.ecommerce_demo.model.ProductRequest;
import org.accenture.ecommerce_demo.model.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface IProductService {
    ProductResponse createProduct(ProductRequest request);

    ProductResponse getProductById(UUID id);

    ProductResponse updateProduct(UUID id, ProductRequest request);

    ProductResponse deleteProduct(UUID id);
}
