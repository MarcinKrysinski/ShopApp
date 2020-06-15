package entity;

import entity.enums.ProductSeparators;

public class Cloth extends Product {

    public final static String productType = ProductSeparators.CLOTH_ID.toString();

    private String size;
    private String material;

    public Cloth(Long id, String productName, Double price, Double weight, String color, Long productCount, String size, String material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return productType + separator + super.toString() + separator + size +separator + material;
    }
}
