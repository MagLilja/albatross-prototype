package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.services.AdminProductService;
import se.yrgo.SPGroup2.services.PhotoAlreadyExistsException;
import se.yrgo.SPGroup2.services.ProductAlreadyExistsException;

import java.util.Optional;


@RestController
@RequestMapping(value = "/admin/products")
public class AdminProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AdminProductService productService;


    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createProduct(@RequestBody AddProductRequest productRequestPayload) {

        try {
            return productService.createProduct(productRequestPayload);
        } catch (ProductAlreadyExistsException e) {
            return new ResponseEntity<>("Product with Art Nr already exists", HttpStatus.BAD_REQUEST);
        } catch (PhotoAlreadyExistsException e) {
            return new ResponseEntity<>("Photo with that filename already exists", HttpStatus.BAD_REQUEST);
        }


    }


    @PutMapping(value = "/{artNr}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateProducts(@PathVariable String artNr, @RequestBody AddProductRequest payload) {
//        Product productToUpdate = productRepository.findByArtNum(artNr);
//        productToUpdate.setArtNum(product.getArtNum());
//        productToUpdate.setType(product.getType());
//        productToUpdate.setModel(product.getModel());
//        productToUpdate.setSize(product.getSize());
//        productToUpdate.setColor(product.getColor());
//        productToUpdate.setPrice(product.getPrice());

        Product product = payload.getProduct();
        Stock stock = product.getStock();
        if (stock != null) {
            stock.setAmountInStock(payload.getAmountInStock());
        } else {
            stock = new Stock(payload.getAmountInStock(), product);

        }
        product.setStock(stock);
        productRepository.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{artNr}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Product> deleteProduct(@PathVariable String artNr) {
        Optional<Product> productToDelete = productRepository.findByArtNum(artNr);
        productToDelete.ifPresentOrElse(productRepository::delete, () -> {
            throw new ProductNotFoundException("Product not found");
        });
        return ResponseEntity.ok().build();
    }
}
