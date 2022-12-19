package se.yrgo.SPGroup2.services;

import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductService {

     Product getProductByArtNr(String artNr) throws NoProductFoundException;

     List<Product> getProductsByType(ProductType type);
     List<Product> getProductsByModel(String model) throws NoProductFoundException;

     List<Product> getAllProducts() throws NoProductFoundException;
}
