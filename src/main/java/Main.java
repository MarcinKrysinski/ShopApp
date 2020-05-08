import DAO.ProductDAOImpl;
import api.ProductDAO;
import entity.Boots;
import entity.Cloth;
import entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Cloth cloth = new Cloth(1L, "T-shirt", 35.99, 0.3, "White", 10,"L", "COTTON");

        List<Product> bootsList = new ArrayList<Product>();
        bootsList.add(new Boots(1L, "Boots", 99.99, 0.5, "Black", 15, 43, true));
        bootsList.add(new Boots(2L, "Boots2", 59.99, 0.5, "Green", 25, 41, false));
        bootsList.add(new Boots(3L, "Boots3", 69.99, 0.5, "White", 05, 39, true));


        ProductDAO productClothDao = new ProductDAOImpl("clothes", "CLOTH");
        productClothDao.saveProduct(cloth);

        ProductDAO productBootsDao = new ProductDAOImpl("boots", "BOOTS");
        productBootsDao.saveProducts(bootsList);
        productBootsDao.removeProductByName("Boots2");
        productBootsDao.saveProducts(bootsList);
        productBootsDao.getAllProducts();



    }
}