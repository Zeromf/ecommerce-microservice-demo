package org.accenture.ecommerce_demo.exception;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(String productName) {
        super("Producto con el nombre '" + productName + "' ya existe.");
    }
}