package api;

import entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    long getProductCount();
    Product getProductByName(String productName);
    boolean isProductAvailable(String productName);
    boolean isProductExist(String productName);
    boolean isProductExist(long id);


}
