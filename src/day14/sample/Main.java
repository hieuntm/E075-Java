package day14.sample;


import day14.sample.model.Product;
import day14.sample.service.ProductService;
import day14.sample.utils.InputUtils;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ProductService prdManagement = new ProductService();
        int chon;
        do {
            menu();
            chon = InputUtils.inputDigit(1, 3, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    // Tạo product
                    Product product = generateRandomProduct(); // Nhập dữ liệu vào
                    prdManagement.insertProduct(product);
                    break;
                case 2:
                    break;
                case 3:
                    // Hiển thị danh sách product
                    System.out.println(prdManagement.getAllProducts());
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
            }
        } while (chon != 4);
    }

    private static final String[] productLines = {"Classic Cars", "Motorcycles", "Planes", "Ships", "Trains", "Trucks and Buses", "Vintage Cars"};
    private static final String[] productScales = {"1:10", "1:12", "1:18", "1:24", "1:32", "1:50", "1:72"};
    private static final String[] productVendors = {"VendorA", "VendorB", "VendorC", "VendorD"};
    private static final String[] productDescriptions = {"High quality", "Limited edition", "Collector's item", "Handcrafted"};

    public static Product generateRandomProduct() {
        Random random = new Random();
        String productCode = "P" + String.format("%04d", random.nextInt(10000));
        String productName = "Product" + random.nextInt(1000);
        String productLine = productLines[random.nextInt(productLines.length)];
        String productScale = productScales[random.nextInt(productScales.length)];
        String productVendor = productVendors[random.nextInt(productVendors.length)];
        String productDescription = productDescriptions[random.nextInt(productDescriptions.length)];
        int quantityInStock = random.nextInt(1000);
        double buyPrice = 10 + (1000 - 10) * random.nextDouble();
        double msrp = buyPrice + (100 - 10) * random.nextDouble();

        return new Product(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, msrp);
    }

    public static void menu() {
        System.out.println("1. Tạo product");
        System.out.println("2. Tìm kiếm product theo ID");
        System.out.println("3. Hiển thị danh sách product");
        System.out.println("4. Xoá product theo ID");
        System.out.println("5. Thoát");
    }
}
