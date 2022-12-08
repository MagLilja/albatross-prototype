package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.ProductRepository;


@RestController
@RequestMapping(value = "/admin/products")
public class AdminProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("")
    public Product createProducts(@RequestBody Product product) {
        productRepository.save(product);
        return product;
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
