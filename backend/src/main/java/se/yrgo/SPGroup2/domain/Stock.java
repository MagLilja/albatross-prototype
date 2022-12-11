package se.yrgo.SPGroup2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @Column(name = "product_id")
    private long id;

    private int amountInStock;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;



    public Stock() {

    }

    public Stock(int amountInStock, Product product) {
        this.amountInStock = amountInStock;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
