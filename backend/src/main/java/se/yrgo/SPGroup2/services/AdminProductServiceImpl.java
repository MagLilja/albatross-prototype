package se.yrgo.SPGroup2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.yrgo.SPGroup2.domain.Photo;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;
import se.yrgo.SPGroup2.repositories.ProductRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<Product> createProduct(AddProductRequest productRequestPayload) {
        Product newProduct = productRequestPayload.getProduct();
        newProduct.setStock(new Stock(productRequestPayload.getAmountInStock(), newProduct));

        List<Photo> photoList = new ArrayList<>();

        productRequestPayload.getPhotos().forEach(string -> {
            photoList.add(new Photo(string));
        });

        newProduct.setPhotoList(photoList);
        productRepository.save(newProduct);
        return ResponseEntity.created(URI.create("/admin/products")).build();
    }

    @Override
    public ResponseEntity<Product> updateProduct(AddProductRequest productRequestPayload) {
        return null;
    }

    @Override
    public ResponseEntity<Product> deleteProduct(AddProductRequest productRequestPayload) {
        return null;
    }
}
