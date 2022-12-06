package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;


@RestController
@RequestMapping(value = "/admin/products")
public class AdminProductController {


    @PostMapping("")
    public Product createProducts(@RequestBody Product product) {
        return product;
    }

    @PutMapping(value = "/{artNr}")
    public Product updateProducts(@PathVariable String artNr, @RequestBody Product product) {
        return product;
    }

    @DeleteMapping(value = "/{artNr}")
    public Product deleteProducts(@PathVariable String artNr) {
        return new Product("1", ProductType.JACKETS, "Arboga", ProductSize.M, "Prison pink", 1000);
    }
}
