package validator;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

public class ProductValidator {

    private static ProductValidator instance = null;

    private ProductValidator() {

    }

    public static ProductValidator getInstance() {
        if (instance == null){
            instance = new ProductValidator();
        }
        return instance;
    }

    public boolean isValid(Product product) throws ProductPriceNoPositiveException, ProductCountNegativeException, ProductWeightNoPositiveException, ProductNameEmptyException {
        if (isPriceLowerThanZero(product.getPrice())){
            throw new ProductPriceNoPositiveException("Product price is not greater than zero");
        }
        else if (isProductCountNegative(product.getProductCount())){
            throw new ProductCountNegativeException("Product count is negative");
        }
        else if (isProductWeightLowerThanZero(product.getWeight())){
            throw new ProductWeightNoPositiveException("Product weight is not greater than zero");
        }
        else if (isProductNameIsEmpty(product.getProductName())){
            throw new ProductNameEmptyException("Product name is empty");
        }
        return true;
    }




    private boolean isPriceLowerThanZero(Double price) {
        if (price <= 0){
            return true;
        }
        return false;
    }


    private boolean isProductCountNegative(Long productCount) {
        if(productCount <= 0){
            return true;
        }
        return false;
    }


    private boolean isProductWeightLowerThanZero(Double weight) {
        if(weight <= 0){
            return true;
        }
        return false;
    }


    private boolean isProductNameIsEmpty(String productName) {
        if (productName.length() == 0){
            return true;
        }
        return false;
    }


}
