
import DAO.ProductDAOImpl;
import api.ProductDAO;
import api.ProductFacade;
import api.UserRegisterLoginFacade;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.User;
import entity.enums.Colors;
import entity.enums.Materials;
import entity.enums.SkinType;
import entity.parse.ColorParser;
import entity.parse.MaterialParser;
import entity.parse.SkinParser;
import facade.ProductFacadeImpl;
import facade.UserRegisterLoginFacadeImpl;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zarejestruj się");
        System.out.println("0 - Wyjdź");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy produkt");
        System.out.println("2 - Usuń produkt");
        System.out.println("3 - Wyświetl dostepne produkty");
        System.out.println("0 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
    }

    public static Product createOtherProduct() {
        String productName;
        Colors color;
        Double price, weight;
        Long count;
        System.out.println("Nazwa produktu: ");
        productName = scanner.next();

        System.out.println("Cena: ");
        price = scanner.nextDouble();

        System.out.println("Waga: ");
        weight = scanner.nextDouble();

        System.out.println("Wybierz kolor: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.convertStringToColor(scanner.next());

        System.out.println("Liczba sztuk: ");
        count = scanner.nextLong();

        return new Product(1L, productName, price, weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName;
        Colors color;
        Double price, weight;
        Long count;
        Integer size;
        SkinType skinType;

        System.out.println("Nazwa produktu: ");
        productName = scanner.next();

        System.out.println("Cena: ");
        price = scanner.nextDouble();

        System.out.println("Waga: ");
        weight = scanner.nextDouble();

        System.out.println("Wybierz kolor: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.convertStringToColor(scanner.next());

        System.out.println("Liczba sztuk: ");
        count = scanner.nextLong();

        System.out.println("Rozmiar: ");
        size = scanner.nextInt();

        System.out.println("Wybierz rodzaj skóry: NATURAL, ARTIFICIAL");
        skinType = SkinParser.convertStringToSkin(scanner.next());


        return new Boots(1L, productName, price, weight, color, count, size, skinType);
    }

    public static Product createClothProduct() {
        String productName, size;
        Colors color;
        Materials material;
        Double price, weight;
        Long count;

        System.out.println("Nazwa produktu: ");
        productName = scanner.next();

        System.out.println("Cena: ");
        price = scanner.nextDouble();

        System.out.println("Waga: ");
        weight = scanner.nextDouble();

        System.out.println("Wybierz kolor: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.convertStringToColor(scanner.next());

        System.out.println("Liczba sztuk: ");
        count = scanner.nextLong();

        System.out.println("Rozmiar: ");
        size = scanner.next();

        System.out.println("Wybierz materiał: LEATHER, FUR, COTTON, WOOL, POLYESTERS ");
        material = MaterialParser.convertStringToMaterial(scanner.next());


        return new Cloth(1L, productName, price, weight, color, count, size, material);
    }

    public static void main(String[] args) throws IOException {

//        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
//        ProductFacade productFacade = ProductFacadeImpl.getInstance();
//
//        boolean appOn = true;
//        boolean loggedOn = false;
//        int read;
//
//        while (appOn) {
//            startMenu();
//            read = scanner.nextInt();
//
//            switch (read) {
//                case 1:
//                    System.out.println("Podaj login:");
//                    String loginLog = scanner.next();
//                    System.out.println("Podaj hasło:");
//                    String passwordLog = scanner.next();
//                    if (userFacade.loginUser(loginLog, passwordLog)) {
//                        loggedOn = true;
//                        System.out.println("Zalogowałeś się!");
//                    } else {
//                        System.out.println("Niepoprawne dane!");
//                    }
//                    break;
//                case 2:
//                    System.out.println("Podaj login:");
//                    String loginReg = scanner.next();
//                    System.out.println("Podaj hasło:");
//                    String passwordReg = scanner.next();
//                    User user = new User(1L, loginReg, passwordReg);
//                    userFacade.registerUser(user);
//                    break;
//                case 0:
//                    appOn = false;
//                    break;
//            }
//
//            while (loggedOn) {
//
//                loggedMenu();
//                read = scanner.nextInt();
//
//                switch (read) {
//                    case 1:
//                        productTypeMenu();
//                        read = scanner.nextInt();
//                        Product product = null;
//                        switch (read) {
//                            case 1:
//                                product = createBootsProduct();
//                                break;
//                            case 2:
//                                product = createClothProduct();
//                                break;
//                            case 3:
//                                product = createOtherProduct();
//                                break;
//                        }
//                        productFacade.createProduct(product);
//                        break;
//                    case 2:
//                        System.out.println("Dostepne produkty: ");
//                        System.out.println(productFacade.getAllProducts());
//
//                        System.out.println("Podaj nazwę produktu który chcesz usunać: ");
//                        String productName = scanner.next();
//                        productFacade.removeProduct(productName);
//                        break;
//                    case 3:
//                        System.out.println(productFacade.getAllProducts());
//                        break;
//                    case 0:
//                        loggedOn = false;
//                        break;
//                }
//            }
//        }

        ProductDAOImpl productDAO = ProductDAOImpl.getInstance();
        List<Product> productList = productDAO.getAllProducts();
        System.out.println(productList);
    }


}