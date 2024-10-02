package org.accenture.ecommerce_demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.accenture.ecommerce_demo.exception.*;
import org.accenture.ecommerce_demo.service.IProductService;

import org.accenture.ecommerce_demo.model.ProductRequest;
import org.accenture.ecommerce_demo.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/product")
@Tag(name = "Product API", description = "API to manage Products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @PostMapping("/products")
    @Operation(summary = "Crea un nuevo producto", description = "Permite la creación de un nuevo producto en el sistema.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Producto creado con éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Conflicto, el producto ya existe.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        ProductResponse productResponse = productService.createProduct(request);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene detalles de un producto específico", description = "Recupera los detalles de un producto por su ID único.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Éxito al recuperar los detalles del producto", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<?> getProductDetails(@PathVariable UUID id) {
        try {
            ProductResponse productDetails = productService.getProductById(id);
            return ResponseEntity.ok(productDetails);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(ex.getMessage()));
        }
    }



    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un producto existente", description = "Permite la actualización de los detalles de un producto específico.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto actualizado con éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Conflicto al actualizar el producto.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<?> updateProduct(@PathVariable UUID id, @RequestBody ProductRequest request) {
        try {
            ProductResponse updatedProduct = productService.updateProduct(id, request);
            return ResponseEntity.ok(updatedProduct);
        } catch (BadRequestException ex) {
            return ResponseEntity.badRequest().body(new ApiError(ex.getMessage()));
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(ex.getMessage()));
        } catch (ProductAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(ex.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un producto específico", description = "Permite la eliminación de un producto del sistema usando su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Producto eliminado con éxito", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductResponse.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @ApiResponse(responseCode = "409", description = "Conflicto: el producto tiene historial de ventas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class)))
    })
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        try {
            ProductResponse response = productService.deleteProduct(id);
            return ResponseEntity.ok(response);
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError(ex.getMessage()));
        } catch (ProductHasSalesHistoryException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(ex.getMessage()));
        }
    }

}