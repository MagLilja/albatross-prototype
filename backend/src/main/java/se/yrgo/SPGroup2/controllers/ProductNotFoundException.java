package se.yrgo.SPGroup2.controllers;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String product_not_found) {
    }
}
