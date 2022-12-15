package se.yrgo.SPGroup2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import se.yrgo.SPGroup2.enums.ProductType;

import java.util.List;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(unique = true)
    private String filename;

    @JsonIgnore
    @ManyToMany(mappedBy = "photoList")
    private List<Product> products;





    public Photo() {
    }

    public Photo(String filename) {

        this.filename = filename;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
