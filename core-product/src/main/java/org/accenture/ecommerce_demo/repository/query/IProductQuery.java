package org.accenture.ecommerce_demo.repository.query;

import org.accenture.ecommerce_demo.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductQuery {
    Optional<Product> getProductById(UUID productId);
    List<Product> getProductsByCategory(String categoryName);
}