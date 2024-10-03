package org.accenture.ecommerce_demo.service;

import org.accenture.ecommerce_demo.entity.Category;
import org.accenture.ecommerce_demo.model.ProductCategory;
import org.accenture.ecommerce_demo.repository.query.ICategoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryQuery categoryQuery;

    @Override
    public ProductCategory getProductCategory(int categoryId) {
        Category category = categoryQuery.getCategoryById(categoryId);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(category.getCategoryId());
        productCategory.setName(category.getName());
        return productCategory;
    }

    @Override
    public Boolean categoryExists(int categoryId) {
        Category category=categoryQuery.getCategoryById(categoryId);
        return  category!=null;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return null;
    }

}
