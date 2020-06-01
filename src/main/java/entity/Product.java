package entity;

public class Product {

    public final static char productType = 'P';
    public final static String separator = "  ";

    private Long id;
    private String productName;
    private Double price;
    private Double weight;
    private String color;
    private Long productCount;

    public Product(Long id, String productName, Double price, Double weight, String color, Long productCount) {
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

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return productType + separator + id + separator + productName + separator + price + separator + weight + separator + color + separator + productCount;
    }
}
