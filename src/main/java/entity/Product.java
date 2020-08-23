package entity;

import entity.enums.Colors;
import entity.enums.ProductSeparators;

public class Product {

    public String productType = ProductSeparators.PRODUCT_ID.toString();
    public String separator = ProductSeparators.PRODUCT_SEPARATOR.toString();

    private Long id;
    private String productName;
    private Double price;
    private Double weight;
    private Colors color;
    private Long productCount;

    public Product(Long id, String productName, Double price, Double weight, Colors color, Long productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Double getWeight() {
        return weight;
    }

    public Colors getColor() {
        return color;
    }


    protected String getBasicProductString() {
        return id + separator + productName + separator + price + separator + weight + separator + color + separator + productCount;
    }

    @Override
    public String toString() {
        return productType + separator + getBasicProductString();
    }
}
