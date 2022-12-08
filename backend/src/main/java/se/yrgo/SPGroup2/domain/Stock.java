package se.yrgo.SPGroup2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Stock {
    @Id
    private int id;
    @OneToOne
    private Product product;
    private int amountInStock;


    public Stock() {

    }
    public Stock(Product product, int amountInStock) {
        this.product = product;
        this.amountInStock = amountInStock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
}
