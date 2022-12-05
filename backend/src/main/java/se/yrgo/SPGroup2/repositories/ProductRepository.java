package se.yrgo.SPGroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.yrgo.SPGroup2.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByModel(String model);
    public Product findByArtNum(String artNum);

}