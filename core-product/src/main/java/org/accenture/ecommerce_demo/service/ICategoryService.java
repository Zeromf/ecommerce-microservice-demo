package org.accenture.ecommerce_demo.service;

import org.accenture.ecommerce_demo.entity.Category;
import org.accenture.ecommerce_demo.model.ProductCategory;

public interface ICategoryService {
    ProductCategory getProductCategory(int categoryId);

    Boolean categoryExists(int categoryId);

    Category getCategoryById(int categoryId);
}
