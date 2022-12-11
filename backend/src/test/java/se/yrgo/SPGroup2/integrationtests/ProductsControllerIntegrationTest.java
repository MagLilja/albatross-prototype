package se.yrgo.SPGroup2.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import se.yrgo.SPGroup2.controllers.ProductController;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductsControllerIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductController productController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllProductsTest() throws Exception {

        List<Product> initalProducts = productController.getAllProducts();

        Product product = new Product("1234561", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        Product product2 = new Product("1234562", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);

        productRepository.saveAll(List.of(product, product2));

        assertThat(productController.getAllProducts()).size().isEqualTo(initalProducts.size() + 2);
    }

    @Test
    void getProductsByArtNr() {
        //given
        Product product = new Product("1234563", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        //when
        productRepository.save(product);

        //then
        assertThat(productController.getProductsByArtNr("1234563")).isEqualTo(product);
        assertThat(productController.getProductsByArtNr("123456X")).isNull();
    }

    @Test
    void getProductsByType() {
        //given
        Product product = new Product("1234565", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        Product product2 = new Product("1234566", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        Product product3 = new Product("1234567", ProductType.JACKETS, "Nike", ProductSize.S, "Black", 1000);
        Product product4 = new Product("1234568", ProductType.VESTS, "Nike", ProductSize.S, "Black", 1000);
        List<Product> jackets = productController.getAllProducts().stream()
                .filter(p -> p.getType().equals(ProductType.JACKETS))
                .toList();
        //when

        productRepository.saveAll(List.of(product, product2, product3, product4));

        //then
        assertThat(productController.getProductsByType(ProductType.JACKETS.toString())).size().isEqualTo(jackets.size() + 1);


    }

}