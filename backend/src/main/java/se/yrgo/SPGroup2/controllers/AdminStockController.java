package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.repositories.StockRepository;

import java.beans.Transient;
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
    @Transient
    public void createStock(@PathVariable String artNum, @PathVariable int amountInStock) {
        Product byArtNum = productRepository.findByArtNum(artNum);
//        byArtNum.setStock(new Stock(amountInStock));
        productRepository.save(byArtNum);
    }

    @PutMapping("/{artNum}/{amountInStock}")
    public void updateStock(@PathVariable String artNum, @PathVariable int amountInStock) {
        Product productStockToUpdate = productRepository.findByArtNum(artNum);
        Optional<Stock> stock = Optional.ofNullable(productStockToUpdate.getStock());

        if (stock.isPresent()) {
            stock.get().setAmountInStock(amountInStock);
            stockRepository.save(stock.get());
        } else {
            Stock stock1 = new Stock(amountInStock, productStockToUpdate);
            stockRepository.save(stock1);
            productStockToUpdate.setStock(stock1);
            productRepository.save(productStockToUpdate);
        }


    }


}
