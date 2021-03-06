import api.ProductFacade;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Colors;
import entity.enums.Materials;
import entity.enums.SkinType;
import facade.ProductFacadeImpl;
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

        productList.add(new Boots(1L, "Buty", 87.89, 1D, Colors.BLACK, 10L, 43, SkinType.NATURAL));
        productList.add(new Cloth(2L, "T-shirt", 59D, 0.3, Colors.WHITE ,20L, "XL", Materials.COTTON));

        //then
        ProductFacade productFacade = new ProductFacadeImpl();
//        productFacade.
        productFacade.createProduct(productList.get(0));
        productFacade.createProduct(productList.get(1));
        List<Product> productFromTestClass = productFacade.getAllProducts();

        //when
        Assertions.assertEquals(productList, productFromTestClass);
    }
//
//    @Test
//    public void getAllCountProductsOnTheListTest(){
//
//        //is
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
//        productList.add(new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON"));
//        double countProductOnTheList = productList.size();
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(productList);
//        List<Product> productFromTestClass = productService.getAllProducts();
//        double countProductOnTheListFromTestClass = productFromTestClass.size();
//
//        //when
//        Assertions.assertEquals(countProductOnTheList, countProductOnTheListFromTestClass);
//        Assertions.assertEquals(2, countProductOnTheListFromTestClass);
//    }
//
//    @Test
//    public void getProductByNameIfExistTest(){
//
//        //is
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
//        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
//        productList.add(cloth);
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(productList);
//        Product product = productService.getProductByName("T-shirt");
//
//        //when
//        Assertions.assertEquals(cloth, product);
//    }
//
//    @Test
//    public void getProductByNameNotExistTest(){
//
//        //is
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
//        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
//        productList.add(cloth);
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(productList);
//        Product product = productService.getProductByName("Rower");
//
//        //when
//        Assertions.assertNull(product);
//    }
//
//    @Test
//    public void isProductOnTheShopByNameTest(){
//
//        //is
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
//        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
//        productList.add(cloth);
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(productList);
//        boolean isProductOnTheShopByName = productService.isProductOnTheShopByName("T-shirt");
//
//        //when
//        Assertions.assertTrue(isProductOnTheShopByName);
//    }
//
//    @Test
//    public void isNotProductOnTheShopByNameTest(){
//
//        //is
//        List<Product> productList = new ArrayList<Product>();
//        productList.add(new Boots(1L, "Buty", 87.89, 1, "black", 10, 43, true));
//        Product cloth = new Cloth(2L, "T-shirt", 59, 0.3, "white" ,20, "XL", "COTTON");
//        productList.add(cloth);
//
//        //then
//        ProductServiceImpl productService = new ProductServiceImpl(productList);
//        boolean isProductOnTheShopByName = productService.isProductOnTheShopByName("Rower");
//
//        //when
//        Assertions.assertFalse(isProductOnTheShopByName);
//    }

}
