package org.accenture.ecommerce_demo.repository.command;

import org.accenture.ecommerce_demo.entity.Product;

public interface IProductCommand {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
}