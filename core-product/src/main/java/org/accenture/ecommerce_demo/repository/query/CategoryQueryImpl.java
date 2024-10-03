package org.accenture.ecommerce_demo.repository.query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.accenture.ecommerce_demo.entity.Category;
import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.repository.ICategoryRepository;
import org.accenture.ecommerce_demo.repository.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryQueryImpl implements ICategoryQuery{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Category getCategoryById(int categoryId) {
        return entityManager.find(Category.class, categoryId);
    }
}
