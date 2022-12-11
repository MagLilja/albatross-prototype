package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.repositories.NoStockRecordException;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.repositories.StockRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{artNr}")
    public ResponseEntity<Integer> getStockForArtNr(@PathVariable String artNr) {
        return ResponseEntity.ok(productRepository.findByArtNum(artNr).getStock().getAmountInStock());


    }

}
