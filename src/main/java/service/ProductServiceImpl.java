package service;

import DAO.ProductDAOImpl;
import api.ProductDAO;
import api.ProductService;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import validator.ProductValidator;
import java.io.IOException;
import java.util.List;


public class ProductServiceImpl implements ProductService {

    private static ProductServiceImpl instance = null;
    private ProductDAO productDAO = new ProductDAOImpl();
    private ProductValidator productValidator = ProductValidator.getInstance();

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public ProductServiceImpl() {
    }

    public List<Product> getAllProducts() throws IOException {
        return productDAO.getAllProducts();
    }

    public long getProductCount() throws IOException {
        return productDAO.getAllProducts().size();
    }

    public Product getProductByName(String productName) throws IOException {
        List<Product> products = getAllProducts();
        Product searchedProductByName = products.stream().filter(product -> {
            try {
                return isProductAvailable(productName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }).filter(product -> product.getProductName().equals(productName)).findFirst().orElse(null);
        return searchedProductByName;
    }

    public Product getProductById(Long id) throws IOException {
        List<Product> products = getAllProducts();
        return products.stream().filter(product -> product.getId().equals(id))
                .findFirst().orElse(null);
    }

    public boolean isProductAvailable(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        boolean isExist = isProductExist(productName);
        return productList.stream()
                .filter(product -> product.getProductName().equals(productName))
                .anyMatch(product -> (isExist && product.getProductCount()>0));
    }

    public boolean isProductExist(String productName) throws IOException {
        Product product = null;
        product = getProductByName(productName);

        return product != null;
    }


    public boolean isProductExist(Long id) throws IOException {
        Product product = null;
        product = getProductById(id);

        return product != null;
    }

    public boolean saveProduct(Product product) throws ProductPriceNoPositiveException, ProductNameEmptyException, ProductCountNegativeException, ProductWeightNoPositiveException, IOException {
        if (productValidator.isValid(product)) {
            productDAO.saveProduct(product);
            return true;
        }

        return false;

    }

    public void removeProduct(String productName) throws Exception {
        productDAO.removeProductByName(productName);
    }


}
