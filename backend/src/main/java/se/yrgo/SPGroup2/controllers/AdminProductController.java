package se.yrgo.SPGroup2.controllers;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.repositories.StockRepository;

import java.net.URI;


@RestController
@RequestMapping(value = "/admin/products")
public class AdminProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        product.setStock(new Stock(0, product));
        productRepository.save(product);
        return ResponseEntity.created(URI.create("/admin/products")).build();
    }



    @PutMapping(value = "/{artNr}")
    public Product updateProducts(@PathVariable String artNr, @RequestBody Product product) {
        Product productToUpdate = productRepository.findByArtNum(artNr);
        productToUpdate.setArtNum(product.getArtNum());
        productToUpdate.setType(product.getType());
        productToUpdate.setModel(product.getModel());
        productToUpdate.setSize(product.getSize());
        productToUpdate.setColor(product.getColor());
        productToUpdate.setPrice(product.getPrice());
        productRepository.save(productToUpdate);
        return product;
    }

    @DeleteMapping(value = "/{artNr}")
    public Product deleteProduct(@PathVariable String artNr) {
        Product productToDelete = productRepository.findByArtNum(artNr);
        productRepository.delete(productToDelete);
        return productToDelete;
    }
}
