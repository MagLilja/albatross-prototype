package se.yrgo.SPGroup2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.User;
import se.yrgo.SPGroup2.domain.UserDetailsImpl;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.ProductRepository;
import se.yrgo.SPGroup2.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService  {
  @Autowired
  ProductRepository productRepository;


  @Override
  public Product getProductByArtNr(String artNr) throws NoProductFoundException {
    Optional<Product> byArtNum = productRepository.findByArtNum(artNr);
    if (byArtNum.isEmpty()) {
      throw new NoProductFoundException("No product with that artNum");
    }
    return byArtNum.get();
  }

  @Override
  public List<Product> getProductsByType(ProductType type) {
    return productRepository.findByType(type);
  }

  @Override
  public List<Product> getAllProducts() throws NoProductFoundException {
    List<Product> all = productRepository.findAll();
    if (all.isEmpty()) {
      throw new NoProductFoundException("No products found");
    }
    return all;
  }

}
