package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.repositories.NoStockRecordException;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.repositories.StockRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "admin/stock")
public class AdminStockController {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public List<Stock> getStocksForAllProducts() {
        return stockRepository.findAll();

    }

    @PostMapping("/{artNum}/{amountInStock}")
    public void createStock(@PathVariable String artNum, @PathVariable int amountInStock) {
        Optional<Product> byArtNum = productRepository.findByArtNum(artNum);
//        byArtNum.setStock(new Stock(amountInStock));
        byArtNum.ifPresentOrElse(productRepository::save, () -> {
            throw new ProductNotFoundException("Product not found");
        });
    }

    @PutMapping("/{artNum}/{amountInStock}")
    public ResponseEntity updateStock(@PathVariable String artNum, @PathVariable int amountInStock) {

            return null;
        }
    }



