package se.yrgo.SPGroup2.integrationtests;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.yrgo.SPGroup2.controllers.ProductController;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProductsRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductController productController;

    @Test
    void contextLoads() {
        assertThat(productRepository).isNotNull();
        assertThat(productController).isNotNull();
    }


    @Test
    void createProduct() {
        //given
        Product product = new Product("123456", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        //when
        productRepository.save(product);

        //then
        assertThat(productRepository.findByArtNum("123456")).isEqualTo(product);
    }

    @Test
    void deleteProduct() {
        //given
        Product product = new Product("123456", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        //when
        productRepository.save(product);
        productRepository.delete(product);
        //then
        assertThat(productRepository.findByArtNum("123456")).isNull();

    }

}