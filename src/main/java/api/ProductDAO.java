package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductDAO {

    void saveProduct(Product product) throws FileNotFoundException;
    void saveProducts(List<Product> products);
    void removeProductById(Long id);
    void removeProductByName(String productName);

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product getProductByName(String productName);
}
