package org.accenture.ecommerce_demo.service.validation;

import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.exception.BadRequestException;
import org.accenture.ecommerce_demo.exception.ProductAlreadyExistsException;
import org.accenture.ecommerce_demo.exception.ProductNotFoundException;
import org.accenture.ecommerce_demo.model.ProductRequest;
import org.accenture.ecommerce_demo.repository.IProductRepository;
import org.accenture.ecommerce_demo.repository.command.IProductCommand;
import org.accenture.ecommerce_demo.repository.query.IProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceExtensionsImpl implements IProductServiceExtensions{

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IProductQuery productQuery;
    @Override
    public void ValidateProductRequest(ProductRequest request) throws BadRequestException {
        List<String> errorMessages = new ArrayList<>();

        if (request.getPrice() <= 0) {
            errorMessages.add("El precio debe ser mayor a cero.");
        }

        if (request.getDiscount() < 0 || request.getDiscount() > 100) {
            errorMessages.add("El descuento debe estar entre 0% y 100%.");
        }

//        if (!categoryService.categoryExists(request.getCategory())) {
//            errorMessages.add("La categoría '" + request.getCategory() + "' no existe.");
//        }

        if (!errorMessages.isEmpty()) {
            throw new BadRequestException(String.join(" ", errorMessages));
        }
    }

    @Override
    public void ValidateProductDoesNotExistByName(ProductRequest request) throws ProductAlreadyExistsException {
        if (productRepository.existsByName(request.getName())) {
            throw new ProductAlreadyExistsException(request.getName());
        }
    }

    @Override
    public void ValidateNameUpdate(UUID id, ProductRequest request) {
        Product product=productQuery.getProductById(id);
        if (!Objects.equals(product.getName(), request.getName()) && productQuery.productExistsByName(request.getName()))
        {
            throw new ProductNotFoundException(id);
        }

    }

    @Override
    public void validateProductExist(UUID productId) {
        Product queryProduct=productQuery.getProductById(productId);
        if (queryProduct==null)
        {
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    public void validateProductHasSaleHistory(UUID productId) throws BadRequestException {
        //verifica si el producto tiene historial de ventas
        Product queryProduct= productQuery.getProductById(productId);
        if (!queryProduct.getSaleProducts().isEmpty()) {
            throw new BadRequestException("El producto tiene historial de ventas y no se puede eliminar.");
        }

    }
}
