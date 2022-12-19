package se.yrgo.SPGroup2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

     List<Product> findByType(ProductType type);
     Optional<Product> findByArtNum(String artNum);

     Optional<List<Product>> findByModel(String model);


}