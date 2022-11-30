package se.yrgo.SPGroup2.model;

public class Pants {

    private long id;
    private String color;
    private String size;
    private String material;

    public Pants() {
    }

    public Pants(long id, String color, String size, String material) {
        this.id = id;
        this.color = color;
        this.size = size;
        this.material = material;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }
}
