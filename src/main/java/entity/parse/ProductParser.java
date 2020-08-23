package entity.parse;

import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Colors;
import entity.enums.Materials;
import entity.enums.ProductSeparators;
import entity.enums.SkinType;

public class ProductParser {

    public static Product convertStringToProduct(String productStr){
        final ProductSeparators productType = ProductSeparators.getProductTypeByChar(productStr.substring(0,1));

//        assert productType != null;
        switch(productType){
            case PRODUCT_ID:
                return lineToObjectProduct(productStr);
            case CLOTH_ID:
                return lineToObjectCloth(productStr);
            case BOOTS_ID:
                return lineToObjectBoots(productStr);
        }
        return null;
    }

    public static Boots lineToObjectBoots(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        Long id = Long.parseLong(productInfo[1]);
        String productName = productInfo[2];
        Double price = Double.parseDouble(productInfo[3]);
        Double weight = Double.parseDouble(productInfo[4]);
        Colors color = ColorParser.convertStringToColor(productInfo[5]);
        long productCount = Integer.parseInt(productInfo[6]);
        int size = Integer.parseInt(productInfo[7]);
        SkinType isNaturalSkin = SkinParser.convertStringToSkin(productInfo[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    public static Cloth lineToObjectCloth(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        long id = Long.parseLong(productInfo[1]);
        String productName = productInfo[2];
        double price = Double.parseDouble(productInfo[3]);
        double weight = Double.parseDouble(productInfo[4]);
        Colors color = ColorParser.convertStringToColor(productInfo[5]);
        long productCount = Integer.parseInt(productInfo[6]);
        String size = productInfo[7];
        Materials material = MaterialParser.convertStringToMaterial(productInfo[8]);

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    public static Product lineToObjectProduct(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(ProductSeparators.PRODUCT_SEPARATOR.toString());

        long id = Long.parseLong(productInfo[1]);
        String productName = productInfo[2];
        double price = Double.parseDouble(productInfo[3]);
        double weight = Double.parseDouble(productInfo[4]);
        Colors color = ColorParser.convertStringToColor(productInfo[5]);
        long productCount = Integer.parseInt(productInfo[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    public static String toUpperCase(String productString){
        return productString.toUpperCase();
    }
}
