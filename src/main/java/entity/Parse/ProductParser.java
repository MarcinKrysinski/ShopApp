package entity.Parse;

import entity.Boots;
import entity.Cloth;
import entity.Product;

public class ProductParser {

    public static Product convertStringToProduct(String productType, String lineFromProductList){

        if (productType.equals(toUpperCase(productType))) {
            return lineToObjectProduct(lineFromProductList);
        }else if (productType.equals(toUpperCase(productType))){
            return lineToObjectCloth(lineFromProductList);
        }else if (productType.equals(toUpperCase(productType))){
            return lineToObjectBoots(lineFromProductList);
        }

        return null;
    }

    public static Boots lineToObjectBoots(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(Product.separator);

        long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        double price = Double.parseDouble(productInfo[2]);
        double weight = Double.parseDouble(productInfo[3]);
        String color = productInfo[4];
        long productCount = Integer.parseInt(productInfo[5]);
        int size = Integer.parseInt(productInfo[6]);
        boolean isNaturalSkin = Boolean.parseBoolean(productInfo[7]);

        return new Boots(id, productName, price, weight, color, productCount, size, isNaturalSkin);
    }

    public static Cloth lineToObjectCloth(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(Product.separator);

        long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        double price = Double.parseDouble(productInfo[2]);
        double weight = Double.parseDouble(productInfo[3]);
        String color = productInfo[4];
        long productCount = Integer.parseInt(productInfo[5]);
        String size = productInfo[6];
        String material = productInfo[7];

        return new Cloth(id, productName, price, weight, color, productCount, size, material);
    }

    public static Product lineToObjectProduct(String lineFromProductList){
        String[] productInfo = lineFromProductList.split(Product.separator);

        long id = Long.parseLong(productInfo[0]);
        String productName = productInfo[1];
        double price = Double.parseDouble(productInfo[2]);
        double weight = Double.parseDouble(productInfo[3]);
        String color = productInfo[4];
        long productCount = Integer.parseInt(productInfo[5]);

        return new Product(id, productName, price, weight, color, productCount);
    }

    public static String toUpperCase(String productString){
        return productString.toUpperCase();
    }
}
