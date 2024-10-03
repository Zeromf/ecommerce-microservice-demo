package org.accenture.ecommerce_demo.exception;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(UUID message) {
        super(String.valueOf(message));
    }
}