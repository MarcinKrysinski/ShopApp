package DAO;

import api.ProductDAO;
import entity.ConvertStringToProduct;
import entity.Product;
import utilities.FileUtilites;

import java.io.*;
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

    public void saveProduct(Product product) throws IOException {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(product);
        saveProducts(productsList);
    }

    public void saveProducts(List<Product> products) throws FileNotFoundException {
        FileUtilites.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product iProduct: products) {
            printWriter.write(iProduct.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeProductById(Long id) throws IOException {
        List<Product> productsList = getAllProducts();

        for (Product iProduct: productsList) {
            if (iProduct.getId() == id){
                removeProductById(id);
            }
        }
        saveProducts(productsList);
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();

        for (Product iProduct: productList){
            if (iProduct.getProductName().equals(productName)){
                productList.remove(iProduct);
                break;
            }
        }
        saveProducts(productList);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> productList = new ArrayList<Product>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String readOneLineFromFile = reader.readLine();
        while(readOneLineFromFile != null) {
            Product product = ConvertStringToProduct.convertStringToProduct(productType, readOneLineFromFile);
            System.out.println(readOneLineFromFile);
            readOneLineFromFile = reader.readLine();
            if (product !=null ){
                productList.add(product);
            }
        }
        reader.close();
        return productList;
    }

    public Product getProductById(Long id) {
        return null;
    }

    public Product getProductByName(String productName) {
        return null;
    }


}
