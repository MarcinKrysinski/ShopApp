package DAO;

import api.ProductDAO;
import entity.parse.ProductParser;
import entity.Product;
import utilities.FileUtilites;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProductDAOImpl implements ProductDAO {

    private static final String fileName = "product.data";
    private static ProductDAOImpl instance = null;

    public ProductDAOImpl()  {
        try {
            FileUtilites.createNewFiles(fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ProductDAOImpl getInstance()  {
        if(instance == null){
            instance = new ProductDAOImpl();
        }
        return instance;
    }


    public void saveProduct(Product product) throws IOException {
        List<Product> productsList = getAllProducts();
        productsList.add(product);
        saveProducts(productsList);
    }

    public void saveProducts(List<Product> productsList) throws FileNotFoundException {
        FileUtilites.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (Product iProduct: productsList) {
            printWriter.write(iProduct.toString() + "\n");
        }
        printWriter.close();
    }

    public void removeProductById(Long id) throws IOException {
        List<Product> productsList = getAllProducts();
        productsList.removeIf(product -> product.getId().equals(id));
        saveProducts(productsList);
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        productList.removeIf(product -> product.getProductName().equals(productName));
        saveProducts(productList);
    }

    public List<Product> getAllProducts() throws IOException {
        List<Product> productList = new ArrayList<>();
        List<String> test = Files.lines(Paths.get(fileName))
                .collect(Collectors.toList());
        test.stream().map(ProductParser::convertStringToProduct)
                .forEach(product -> {
                    if (product != null){
                        productList.add(product);
                    }
                });
        return productList;
    }


    public Product getProductById(Long id) throws IOException {
        List<Product> productList = getAllProducts();
        Product searchedProduct = productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
        return searchedProduct;
    }

    public Product getProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        Product searchedProduct = productList.stream().filter(product -> ProductParser.toUpperCase(product.getProductName()).equals(ProductParser.toUpperCase(productName))).findFirst().orElse(null);
        return searchedProduct;

    }

}
