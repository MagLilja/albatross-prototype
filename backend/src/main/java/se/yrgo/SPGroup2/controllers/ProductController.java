package se.yrgo.SPGroup2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @GetMapping(value = "/{artNr}")
    public Product getProductsByArtNr(@PathVariable String artNr) {
        return productRepository.findByArtNum(artNr);
    }


    @GetMapping(value = "/type")
    public List<Product> getProductsByType(@RequestParam String type) {
        return productRepository.findByType(ProductType.valueOf(type));
    }

}