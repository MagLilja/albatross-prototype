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
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("2", ProductType.JACKETS, "Gislaved", ProductSize.XS, "Blue", 1000));
        productList.add(new Product("3", ProductType.PANTS, "Hjo", ProductSize.S, "Blue", 1000));
        productList.add(new Product("4", ProductType.VESTS, "Paris", ProductSize.M, "Blue", 1000));
        return productList;
    }


    @GetMapping(value = "/{artNr}")
    public Product getProductsByArtNr(@PathVariable String artNr) {
        return new Product("1", ProductType.JACKETS, "Arboga", ProductSize.M, "Prison pink", 1000);
    }


    @GetMapping(value = "/type")
    public Product getProductsByType(@RequestParam String type) {
        return new Product("1", ProductType.JACKETS, "Arboga", ProductSize.M, "Prison pink", 1000);
    }

}