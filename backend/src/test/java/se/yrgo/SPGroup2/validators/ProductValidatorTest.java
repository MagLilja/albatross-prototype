package se.yrgo.SPGroup2.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductValidatorTest {

    @Test
    void validateStringInputShouldThrowExceptionForInvalidInput() {
        //given
        String invalidInput = "<script>alert('hello')</script>";
        //then
        assertThrows(IllegalArgumentException.class, () -> ProductValidator.validateStringInput(invalidInput));
    }
}