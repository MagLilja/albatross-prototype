package se.yrgo.SPGroup2.domain.payloads;

import se.yrgo.SPGroup2.domain.Product;

import java.util.List;
import java.util.Objects;

public class AddProductRequest {
private Product product;
private int amountInStock;
private List<String> photos;

    public AddProductRequest() {
    }

    public AddProductRequest(Product product, int amountInStock, List<String> photos) {

        this.product = product;
        this.amountInStock = amountInStock;
        this.photos = photos;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProductRequest that = (AddProductRequest) o;
        return amountInStock == that.amountInStock && Objects.equals(product, that.product) && Objects.equals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, amountInStock, photos);
    }

    @Override
    public String toString() {
        return "AddProductRequest{" +
                "product=" + product +
                ", amountInStock=" + amountInStock +
                ", photos=" + photos +
                '}';
    }
}
