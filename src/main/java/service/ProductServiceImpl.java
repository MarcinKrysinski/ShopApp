package service;

import DAO.ProductDAOImpl;
import api.ProductDAO;
import api.ProductService;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    List<Product> products;
    private static ProductServiceImpl instance = null;
    private ProductDAO productDAO = new ProductDAOImpl("data", "Product");

    public static ProductServiceImpl getInstance() throws IOException {
        if (instance == null){
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public ProductServiceImpl() throws IOException {
    }
//    public ProductServiceImpl(List<Product> productList) {
//        this.products = new ArrayList<Product>(productList);
//    }

    public List<Product> getAllProducts() throws IOException {
        return productDAO.getAllProducts();
    }

    public long getProductCount() throws IOException {
        return productDAO.getAllProducts().size();
    }

    public Product getProductByName(String productName) throws IOException {
        return productDAO.getProductByName(productName);
    }

    public boolean isProductAvailable(String productName) throws IOException {
        for (Product product: getAllProducts()){
            if (isProductExist(productName) && product.getProductCount()>0){
                return true;
            }
        }
        return false;
    }

    public boolean isProductExist(String productName) throws IOException {
        for (Product product :getAllProducts()){
            if (product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }


    public boolean isProductExist(long id) throws IOException {
        Product product = null;
        product = productDAO.getProductById(id);
        if (product == null) {
            return false;
        }
        return true;
    }

    public boolean isProductOnTheShopByName(String productName) throws IOException {
        for (Product product :getAllProducts()){
            if (product.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }
}
