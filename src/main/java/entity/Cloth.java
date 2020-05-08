package entity;

public class Cloth extends Product {

    private String size;
    private String material;

    public Cloth(long id, String productName, double price, double weight, String color, long productCount, String size, String material) {
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
        return super.toString() + separator + size +separator + material;
    }
}
