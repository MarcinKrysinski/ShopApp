package DAO;

import api.ProductDAO;
import entity.Product;
import utilities.FileUtilites;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    private final String fileName;
    private final String productType;

    public ProductDAOImpl(String fileName, String productType) throws IOException {
        this.fileName = fileName;
        this.productType = productType;
        FileUtilites.createNewFiles(fileName);
    }

    public void saveProduct(Product product) throws FileNotFoundException {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(product);
        FileUtilites.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product iProduct: productsList) {
            printWriter.write(iProduct.toString() + "\n");
        }
        printWriter.close();
    }

    public void saveProducts(List<Product> products) {

    }

    public void removeProductById(Long id) {

    }

    public void removeProductByName(String productName) {

    }

    public List<Product> getAllProducts() {
        return null;
    }

    public Product getProductById(Long id) {
        return null;
    }

    public Product getProductByName(String productName) {
        return null;
    }
}
