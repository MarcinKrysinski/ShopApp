package entity;

public class Boots extends Product {

    private int size;
    private boolean isNatural;

    public Boots(long id, String productName, double price, double weight, String color, long productCount, int size, boolean isNatural) {
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
}
