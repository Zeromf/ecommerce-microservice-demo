package org.accenture.ecommerce_demo.service.validation;

import org.accenture.ecommerce_demo.model.ProductRequest;

import java.util.UUID;

public interface IProductServiceExtensions {
   void ValidateProductRequest(ProductRequest request);
   void ValidateProductDoesNotExistByName(ProductRequest request);
   
   void validateProductExist(UUID productId);

   void validateProductHasSaleHistory(UUID productId);
}
