package se.yrgo.SPGroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.Stock;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {


    Optional<Stock> findByProduct(Product product);
}