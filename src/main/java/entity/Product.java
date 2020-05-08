package entity;

public class Product {

    public final static String separator = "  ";

    private long id;
    private String productName;
    private double price;
    private double weight;
    private String color;
    private long productCount;

    public Product(long id, String productName, double price, double weight, String color, long productCount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
        this.color = color;
        this.productCount = productCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getProductCount() {
        return productCount;
    }

    public void setProductCount(long productCount) {
        this.productCount = productCount;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return id + separator + productName + separator + price + separator + weight + separator + color + separator + productCount;
    }
}
