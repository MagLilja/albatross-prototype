package se.yrgo.SPGroup2.domain;

import jakarta.persistence.*;
import se.yrgo.SPGroup2.enums.ProductType;

import java.util.List;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String filename;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    private String model;

    private String color;


    public Photo() {
    }

    public Photo(int id, String filename, ProductType type, String model, String color) {
        this.id = id;
        this.filename = filename;
        this.type = type;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
