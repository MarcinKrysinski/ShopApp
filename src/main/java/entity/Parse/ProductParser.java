package entity.Parse;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product convertStringToProduct(String productStr){
        final char productType = productStr.charAt(0);

        switch(productType){
            case 'P':
                return lineToObjectProduct(productStr);
            case 'C':
                return lineToObjectCloth(productStr);
            case 'B':
                return lineToObjectBoots(productStr);
        }
        return null;
    }

    public static Boots lineToObjectBoots(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(Product.separator);

        Long id = Long.parseLong(productInfo[1]);
        String productName = productInfo[2];
        Double price = Double.parseDouble(productInfo[3]);
        Double weight = Double.parseDouble(productInfo[4]);
        String color = productInfo[5];
        long productCount = Integer.parseInt(productInfo[6]);
        int size = Integer.parseInt(productInfo[7]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInfo[8]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    public static Cloth lineToObjectCloth(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(Product.separator);

        long id = Long.parseLong(productInfo[1]);
        String productName = productInfo[2];
        double price = Double.parseDouble(productInfo[3]);
        double weight = Double.parseDouble(productInfo[4]);
        String color = productInfo[5];
        long productCount = Integer.parseInt(productInfo[6]);
        String size = productInfo[7];
        String material = productInfo[8];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    public static Product lineToObjectProduct(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(Product.separator);

        long id = Long.parseLong(productInfo[1]);
        String productName = productInfo[2];
        double price = Double.parseDouble(productInfo[3]);
        double weight = Double.parseDouble(productInfo[4]);
        String color = productInfo[5];
        long productCount = Integer.parseInt(productInfo[6]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    public static String toUpperCase(String productString){
        return productString.toUpperCase();
    }
}
