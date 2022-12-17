package se.yrgo.SPGroup2.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import se.yrgo.SPGroup2.domain.Product;
import se.yrgo.SPGroup2.domain.payloads.AddProductRequest;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;
import se.yrgo.SPGroup2.services.AdminProductService;
import se.yrgo.SPGroup2.services.AdminProductServiceImpl;
import se.yrgo.SPGroup2.services.PhotoAlreadyExistsException;
import se.yrgo.SPGroup2.services.ProductAlreadyExistsException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class AdminProductControllerTest {

    @InjectMocks
    AdminProductController adminProductController;

    @Mock
    AdminProductServiceImpl adminProductService;

    @Test
    void createProductShouldReturnCreatedSCForValidPayload() throws ProductAlreadyExistsException, PhotoAlreadyExistsException {
        Product product = new Product("000", ProductType.JACKETS, "TEst Model", ProductSize.M, "RED", 12);
        AddProductRequest payload = new AddProductRequest(product, 1, List.of());
        //when
        when(adminProductService.createProduct(payload)).thenReturn(Optional.of(product));

        //then
        assertThat(adminProductController.createProduct(payload).getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}