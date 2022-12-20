package se.yrgo.SPGroup2.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.repositories.PhotoRepository;
import se.yrgo.SPGroup2.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class AdminProductServiceImplTest {

    @InjectMocks
    AdminProductServiceImpl adminProductService;

    @Mock
    ProductRepository productRepository;

    @Test
    void createProductShouldReturnProductFromValidInput() throws ProductAlreadyExistsException, PhotoAlreadyExistsException {
        //given
        Product product = new Product("000", ProductType.JACKETS, "TEst Model", ProductSize.M, "RED", 12);

        AddProductRequest payload = new AddProductRequest(product, 1, List.of());
        //when
        when(productRepository.save(product)).thenReturn(product);
        Optional<Product> product1 = adminProductService.createProduct(payload);

        //then
        assertThat(product1.isPresent()).isTrue();

    }

}