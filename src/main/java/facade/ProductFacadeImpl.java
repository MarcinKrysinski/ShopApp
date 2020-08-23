package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import service.ProductServiceImpl;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class ProductFacadeImpl implements ProductFacade {

    private static ProductFacadeImpl instance = null;
    private ProductService productService = ProductServiceImpl.getInstance();

    public ProductFacadeImpl(){

    }

    public static ProductFacadeImpl getInstance(){
        if(instance == null){
            instance = new ProductFacadeImpl();
        }
        return instance;
    }

    public String createProduct(Product product) {
        try{
            productService.saveProduct(product);
            return "Product created successfully!";
        }catch(ProductNameEmptyException e){
            e.printStackTrace();
            return e.getMessage();
        }catch(ProductPriceNoPositiveException e){
            e.printStackTrace();
            return e.getMessage();
        }catch(ProductCountNegativeException e){
            e.printStackTrace();
            return e.getMessage();
        }catch (ProductWeightNoPositiveException e){
            e.printStackTrace();
            return e.getMessage();
        }catch(IOException e){
            e.printStackTrace();
            return "IOException";
        }

    }

    public String removeProduct(String productName) {
        try{
            productService.removeProduct(productName);
            return "Product removed successfully!";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public List<Product> getAllProducts() {
        try{
            return productService.getAllProducts();
        }catch(IOException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
