package entity;

import entity.enums.ProductSeparators;

public class Boots extends Product {

    public final static String productType = ProductSeparators.BOOTS_ID.toString();

    private int size;
    private boolean isNatural;

    public Boots(Long id, String productName, Double price, Double weight, String color, Long productCount, int size, boolean isNatural) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNatural = isNatural;
    }

    public int getSize() {
        return size;
    }

    public boolean isNatural() {
        return isNatural;
    }

    @Override
    public String toString() {
        return productType + separator + super.toString() + separator + size + separator + isNatural;
    }
}
