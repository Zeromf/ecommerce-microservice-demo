package org.accenture.ecommerce_demo.service;

import jakarta.transaction.Transactional;
import org.accenture.ecommerce_demo.entity.Product;
import org.accenture.ecommerce_demo.exception.BadRequestException;
import org.accenture.ecommerce_demo.exception.ProductAlreadyExistsException;
import org.accenture.ecommerce_demo.exception.ProductNotFoundException;
import org.accenture.ecommerce_demo.model.ProductRequest;
import org.accenture.ecommerce_demo.model.ProductResponse;
import org.accenture.ecommerce_demo.repository.command.IProductCommand;
import org.accenture.ecommerce_demo.repository.query.IProductQuery;
import org.accenture.ecommerce_demo.service.validation.IProductServiceExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductCommand productCommand;
    @Autowired
    private IProductServiceExtensions productServiceExtensions;
    @Autowired
    private IProductQuery productQuery;

    public ProductResponse createProduct(ProductRequest request) throws ProductAlreadyExistsException, BadRequestException {
        productServiceExtensions.ValidateProductDoesNotExistByName(request);
        productServiceExtensions.ValidateProductRequest(request);

        Product product = new Product();
        product.setProductId(UUID.randomUUID());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setDiscount(request.getDiscount());
        product.setImageUrl(request.getImageUrl());
        productCommand.addProduct(product);

        return buildProductResponse(product);
    }

    private ProductResponse buildProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getProductId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setDiscount(product.getDiscount());
        productResponse.setImageUrl(product.getImageUrl());

//        // Obtener la categoría del producto y asignarla a la respuesta
//        String category = categoryService.getProductCategory(product.getCategory());
//        productResponse.setCategory(category);

        return productResponse;
    }



    @Override
    public ProductResponse getProductById(UUID id) {
        productServiceExtensions.validateProductExist(id);
        Product product = productQuery.getProductById(id);
        return buildProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        productServiceExtensions.validateProductExist(id);
        productServiceExtensions.ValidateProductRequest(request);
        productServiceExtensions.ValidateNameUpdate(id,request);

        Product product = productQuery.getProductById(id);

        // Asignar los valores del ProductRequest al producto
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setDiscount(request.getDiscount());
        product.setImageUrl(request.getImageUrl());
        product.setCategory(request.getCategory());

        productCommand.updateProduct(product);

        return buildProductResponse(product);
    }

    public ProductResponse deleteProduct(UUID productId) throws ProductNotFoundException, BadRequestException {
        productServiceExtensions.validateProductExist(productId);
        productServiceExtensions.validateProductHasSaleHistory(productId);

        Product product = productQuery.getProductById(productId);
        productCommand.deleteProduct(product);

        return buildProductResponse(product);
    }
}
