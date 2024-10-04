package org.accenture.ecommerce_demo.repository.command;

import jakarta.transaction.Transactional;
import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.repository.StoreDbContext;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductCommand implements IProductCommand {

    private final StoreDbContext context;

    public ProductCommand(StoreDbContext context) {
        this.context = context;
    }

    @Override
    public void addProduct(Product product) {
        if (product.getProductId() != null) {
            context.getEntityManager().merge(product);
        } else {
            context.getEntityManager().persist(product);
        }
    }
    @Override
    public void updateProduct(Product product) {
        if (product.getProductId() != null) {
            context.getEntityManager().merge(product);
        } else {
            context.getEntityManager().persist(product);
        }
    }

    @Override
    public void deleteProduct(Product product) {
        context.getEntityManager().remove(context.getEntityManager().contains(product) ? product : context.getEntityManager().merge(product));
    }




}