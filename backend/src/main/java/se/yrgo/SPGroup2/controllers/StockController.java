package se.yrgo.SPGroup2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.repositories.StockRepository;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{artNr}")
    public int getStockForArtNr(@PathVariable String artNr) {
        return productRepository.findByArtNum(artNr).getStock().getAmountInStock();
    }

}
