package se.yrgo.SPGroup2.services;

import org.springframework.http.ResponseEntity;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;

import java.util.Optional;

public interface AdminProductService {
    Optional<Product> createProduct(AddProductRequest productRequestPayload) throws ProductAlreadyExistsException, PhotoAlreadyExistsException;

    ResponseEntity<Product> updateProduct(AddProductRequest productRequestPayload);

    ResponseEntity<Product> deleteProduct(AddProductRequest productRequestPayload);

}
