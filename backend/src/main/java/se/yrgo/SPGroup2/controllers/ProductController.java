package se.yrgo.SPGroup2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.services.NoProductFoundException;
import se.yrgo.SPGroup2.services.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    private ProductServiceImpl productServiceImpl;

    /**
     * Endpoint for getting all products.
     *
     * @return List of all products or 404 if no products are found.
     */
    @GetMapping("")
    public ResponseEntity<?> getAllProducts() {
        try {
            return new ResponseEntity<>(productServiceImpl.getAllProducts(), HttpStatus.OK);
        } catch (NoProductFoundException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>("No products with that artNum", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint for a product based on its artNum.
     *
     * @param artNr
     * @return Product with the given artNum or 404 if no product is found.
     */
    @GetMapping(value = "/{artNr}")
    public ResponseEntity<?> getProductsByArtNr(@PathVariable String artNr) {
        Product byArtNum = null;
        try {
            byArtNum = productServiceImpl.getProductByArtNr(artNr);
        } catch (NoProductFoundException e) {
            System.err.println(e.getMessage());
            return new ResponseEntity<>("No product with that artNum", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(byArtNum, HttpStatus.OK);
    }


    @GetMapping(value = "/type")
    public List<Product> getProductsByType(@RequestParam String type) {
        return productServiceImpl.getProductsByType(ProductType.valueOf(type));
    }

}