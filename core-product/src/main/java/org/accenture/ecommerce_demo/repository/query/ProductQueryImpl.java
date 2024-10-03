package org.accenture.ecommerce_demo.repository.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Repository
public class ProductQueryImpl implements IProductQuery{

//    @PersistenceContext
//    private EntityManager entityManager;

    private final IProductRepository productRepository;

    public ProductQueryImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(UUID id) {
        return productRepository.findByIdWithDetails(id);
    }
    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return null;
    }
    @Override
    public boolean productExistsByName(String name) {
        return productRepository.existsByName(name);
    }
}
