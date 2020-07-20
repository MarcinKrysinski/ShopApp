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
//        for (Product iProduct: productsList) {
//            if (iProduct.getId().equals(id)){
//                productsList.remove(id);
//                break;
//            }
//        }
        saveProducts(productsList);
    }

    public void removeProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        productList.removeIf(product -> product.getProductName().equals(productName));

//        for (Product iProduct: productList){
//            if (iProduct.getProductName().equals(productName)){
//                productList.remove(iProduct);
//                break;
//            }
//        }
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


//        FileReader fileReader = new FileReader(fileName);
//        BufferedReader reader = new BufferedReader(fileReader);
//        String readOneLineFromFile = reader.readLine();
//        while(readOneLineFromFile != null) {
//            Product product = ProductParser.convertStringToProduct(readOneLineFromFile);
//            if (product != null){
//                productList.add(product);
//            }
//            readOneLineFromFile = reader.readLine();
//        }
//        reader.close();
        return productList;
    }


    public Product getProductById(Long id) throws IOException {
        List<Product> productList = getAllProducts();
        Product searchedProduct = productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
        return searchedProduct;
//        for (Product iProduct:productList) {
//            if (iProduct.getId().equals(id)){
//                return iProduct;
//            }
//        }
//        return null;
    }

    public Product getProductByName(String productName) throws IOException {
        List<Product> productList = getAllProducts();
        Product searchedProduct = productList.stream().filter(product -> ProductParser.toUpperCase(product.getProductName()).equals(ProductParser.toUpperCase(productName))).findFirst().orElse(null);
        return searchedProduct;

//        for (Product iProduct : productList) {
//            if(ProductParser.toUpperCase(productName).equals(ProductParser.toUpperCase(iProduct.getProductName()))) {
//                return iProduct;
//            }
//        }
//        return null;
    }




}
