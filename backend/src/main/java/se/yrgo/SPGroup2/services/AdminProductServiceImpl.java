package se.yrgo.SPGroup2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.yrgo.SPGroup2.domain.Photo;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;
import se.yrgo.SPGroup2.repositories.PhotoRepository;
import se.yrgo.SPGroup2.repositories.ProductRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PhotoRepository photoRepository;


    @Override
    public ResponseEntity<Product> createProduct(AddProductRequest productRequestPayload) throws ProductAlreadyExistsException, PhotoAlreadyExistsException {
        Product newProduct = productRequestPayload.getProduct();
        validateProduct(newProduct);
        newProduct.setStock(new Stock(productRequestPayload.getAmountInStock(), newProduct));

        List<Photo> photoList = new ArrayList<>();

        List<String> photos = productRequestPayload.getPhotos();
        for (String photo : photos) {
            Photo newPhoto = new Photo(photo);
            validatePhoto(newPhoto);
            photoRepository.save(newPhoto);
            photoList.add(newPhoto);
        }

        newProduct.setPhotoList(photoList);
        productRepository.save(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    private void validatePhoto(Photo newPhoto) throws PhotoAlreadyExistsException {
        if (newPhoto.getFilename() == null || newPhoto.getFilename().isEmpty()) {
            throw new IllegalArgumentException("Photo url cannot be empty");
        }
        Optional<Photo> byFilename = photoRepository.findByFilename(newPhoto.getFilename());
        if (byFilename.isPresent()) {
            throw new PhotoAlreadyExistsException("Photo already exists");
        }
    }

    private void validateProduct(Product newProduct) throws ProductAlreadyExistsException {
        Optional<Product> byArtNum = productRepository.findByArtNum(newProduct.getArtNum());
        if (byArtNum.isPresent()) {
            throw new ProductAlreadyExistsException("Product already exists");
        }

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
