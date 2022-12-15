package se.yrgo.SPGroup2.services;

import org.springframework.http.ResponseEntity;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;

public interface AdminProductService {
    ResponseEntity<Product> createProduct(AddProductRequest productRequestPayload) throws ProductAlreadyExistsException, PhotoAlreadyExistsException;

    ResponseEntity<Product> updateProduct(AddProductRequest productRequestPayload);

    ResponseEntity<Product> deleteProduct(AddProductRequest productRequestPayload);

}
