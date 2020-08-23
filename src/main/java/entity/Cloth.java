package entity;

import entity.enums.Colors;
import entity.enums.Materials;
import entity.enums.ProductSeparators;

public class Cloth extends Product {

    public final static String productType = ProductSeparators.CLOTH_ID.toString();

    private String size;
    private Materials material;

    public Cloth(Long id, String productName, Double price, Double weight, Colors color, Long productCount, String size, Materials material) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public Materials getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return productType + separator + getBasicProductString() + separator + size +separator + material;
    }
}
