package org.accenture.ecommerce_demo.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(UUID productId) {
        super("Producto con el ID " + productId + " no se encontró.");
    }
}