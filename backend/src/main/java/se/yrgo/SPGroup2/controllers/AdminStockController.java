package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yrgo.SPGroup2.domain.Stock;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "admin/stock")
public class AdminStockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("")
    public List<Stock> getStocksForAllProducts(){
        return stockRepository.findAll();

    }

    @GetMapping("/{artNr}")
    public int getStockForArtNr(@PathVariable int artNr){
        return stockRepository.findByArtNr(artNr).getAmountInStock();
    }

}
