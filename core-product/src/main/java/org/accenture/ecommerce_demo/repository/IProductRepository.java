package org.accenture.ecommerce_demo.repository;

import org.accenture.ecommerce_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}