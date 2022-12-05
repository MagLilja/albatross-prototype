package se.yrgo.SPGroup2.domain;

import jakarta.persistence.*;
import se.yrgo.SPGroup2.enums.ProductSize;
import se.yrgo.SPGroup2.enums.ProductType;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String artNum;
    @Enumerated(EnumType.STRING)
    private ProductType type;
    private String model;
    @Enumerated(EnumType.STRING)
    private ProductSize size;
    private String color;
    private int price;

    public Product() {
    }

    public Product(String artNum, ProductType type, String model, ProductSize size, String color, int price) {
        this.artNum = artNum;
        this.type = type;
        this.model = model;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtNum() {
        return artNum;
    }

    public void setArtNum(String artNum) {
        this.artNum = artNum;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ProductSize getSize() {
        return size;
    }

    public void setSize(ProductSize size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}