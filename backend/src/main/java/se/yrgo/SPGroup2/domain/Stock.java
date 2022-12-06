package se.yrgo.SPGroup2.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Stock {
    @Id
    private int id;
    @OneToOne
    private Product artNum;
    private int amountInStock;


    public Stock() {

    }
    public Stock(Product artNum, int amountInStock) {
        this.artNum = artNum;
        this.amountInStock = amountInStock;
    }

    public String getArtNum() {
        return artNum.getArtNum();
    }

    public void setArtNum(Product artNum) {
        this.artNum = artNum;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
}
