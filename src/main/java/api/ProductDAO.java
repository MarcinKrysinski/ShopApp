package api;

import entity.Product;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ProductDAO {

    void saveProduct(Product product) throws FileNotFoundException, IOException;
    void saveProducts(List<Product> products) throws FileNotFoundException;
    void removeProductById(Long id) throws FileNotFoundException, IOException;
    void removeProductByName(String productName) throws FileNotFoundException, IOException;

    List<Product> getAllProducts() throws FileNotFoundException, IOException;
    Product getProductById(Long id);
    Product getProductByName(String productName);
}
