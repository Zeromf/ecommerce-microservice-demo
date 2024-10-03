package org.accenture.ecommerce_demo.repository;

import org.accenture.ecommerce_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProductRepository extends JpaRepository<Product, Long> {

    // Consulta para incluir la relación con Category y SaleProducts
    @Query("SELECT p FROM Product p JOIN FETCH p.categoryName")
    List<Product> findAllWithCategory();

    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.categoryName LEFT JOIN FETCH p.saleProducts WHERE p.productId = :id")
    Product findByIdWithDetails(UUID id);
    boolean existsByName(String name);
}