package service;

import api.ProductService;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl(List<Product> productList) {
        this.products = new ArrayList<Product>(productList);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public long getProductCount() {
        return products.size();
    }

    public Product getProductByName(String productName) {
        for (Product product: products) {
            if (product.getProductName().equals(productName)){
                return product;
            }
        }
        return null;
    }

    public boolean isProductAvailable(String productName) {
        for (Product product: products){
            if (isProductExist(productName) && product.getProductCount()>0){
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(String productName) {
        for (Product product :products){
            if (product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(Long id) {
        for (Product productId : products) {
            if (productId.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isProductOnTheShopByName(String productName) {
        for (Product product :products){
            if (product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }
}
