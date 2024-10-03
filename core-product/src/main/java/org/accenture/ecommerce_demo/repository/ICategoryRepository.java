package org.accenture.ecommerce_demo.repository;

import org.accenture.ecommerce_demo.entity.Category;
import org.accenture.ecommerce_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT p FROM Product p JOIN FETCH p.categoryName")
    List<Product> findAllWithCategory();
    // Método para obtener una categoría por su ID
    boolean existsByName(String name);
}