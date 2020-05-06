import entity.Boots;
import entity.Cloth;
import entity.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void getAllProductsTest(){

        //is
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
        productList.add(new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON"));

        //then
        ProductServiceImpl productService = new ProductServiceImpl(productList);
        List<Product> ProductFromTestClass = productService.getAllProducts();

        //when
        Assertions.assertEquals(productList, ProductFromTestClass);
    }

    @Test
    public void getAllCountProductsOnTheListTest(){

        //is
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
        productList.add(new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON"));
        double countProductOnTheList = productList.size();

        //then
        ProductServiceImpl ProductService = new ProductServiceImpl(productList);
        List<Product> ProductFromTestClass = ProductService.getAllProducts();
        double countProductOnTheListFromTestClass = ProductFromTestClass.size();

        //when
        Assertions.assertEquals(countProductOnTheList, countProductOnTheListFromTestClass);
        Assertions.assertEquals(2, countProductOnTheListFromTestClass);
    }

    @Test
    public void getProductByNameIfExistTest(){

        //is
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
        productList.add(cloth);

        //then
        ProductServiceImpl ProductService = new ProductServiceImpl(productList);
        Product product = ProductService.getProductByName("T-shirt");

        //when
        Assertions.assertEquals(cloth, product);
    }

    @Test
    public void getProductByNameNotExistTest(){

        //is
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
        productList.add(cloth);

        //then
        ProductServiceImpl ProductService = new ProductServiceImpl(productList);
        Product product = ProductService.getProductByName("Rower");

        //when
        Assertions.assertNull(product);
    }

    @Test
    public void isProductOnTheShopByNameTest(){

        //is
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
        productList.add(cloth);

        //then
        ProductServiceImpl ProductService = new ProductServiceImpl(productList);
        boolean isProductOnTheShopByName = ProductService.isProductOnTheShopByName("T-shirt");

        //when
        Assertions.assertTrue(isProductOnTheShopByName);
    }

    @Test
    public void isNotProductOnTheShopByNameTest(){

        //is
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
        productList.add(cloth);

        //then
        ProductServiceImpl ProductService = new ProductServiceImpl(productList);
        boolean isProductOnTheShopByName = ProductService.isProductOnTheShopByName("Rower");

        //when
        Assertions.assertFalse(isProductOnTheShopByName);
    }

}
