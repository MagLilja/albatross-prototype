package se.yrgo.SPGroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {


//    Stock findByProduct(Product product);
}