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

    public Photo(int id, String filename) {
        this.id = id;
        this.filename = filename;
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
}
