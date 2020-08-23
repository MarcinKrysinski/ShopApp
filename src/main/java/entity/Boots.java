package entity;

import entity.enums.Colors;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;


public class Boots extends Product {

    public String productType = ProductSeparators.BOOTS_ID.toString();

    private int size;
    private SkinType isNatural;

    public Boots(Long id, String productName, Double price, Double weight, Colors color, Long productCount, int size, SkinType isNatural) {
        super(id, productName, price, weight, color, productCount);
        this.size = size;
        this.isNatural = isNatural;
    }

    public int getSize() {
        return size;
    }

    public SkinType isNatural() {
        return isNatural;
    }

    @Override
    public String toString() {
        return productType + separator + getBasicProductString() + separator + size + separator + isNatural;
    }


}
