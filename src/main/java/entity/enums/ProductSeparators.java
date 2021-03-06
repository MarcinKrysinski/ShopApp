package entity.enums;

public enum ProductSeparators {
    PRODUCT_SEPARATOR("#"), PRODUCT_ID("P"), CLOTH_ID("C"), BOOTS_ID("B");

    private String character;

    ProductSeparators(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }

    public String getCharacter(){
        return character;
    }

    public static ProductSeparators getProductTypeByChar(String character){
        for (ProductSeparators productType : ProductSeparators.values()) {
            if (productType.getCharacter().equals(character)){
                return productType;
            }
        }
        return null;
    }
}
