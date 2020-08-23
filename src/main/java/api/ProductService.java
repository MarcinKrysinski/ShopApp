package api;

import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws IOException;

    long getProductCount() throws IOException;
    Product getProductByName(String productName) throws IOException;

    boolean isProductAvailable(String productName) throws IOException;
    boolean isProductExist(String productName) throws IOException;
    boolean isProductExist(Long id) throws IOException;

    boolean saveProduct(Product product) throws ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException, IOException;
    void removeProduct(String productName) throws Exception;

}
