package day14.sample.service;

import day14.sample.db.MyConnection;
import day14.sample.model.Product;
import day14.sample.utils.InputUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static day14.sample.utils.MenuUtils.*;

// ProductManagement
public class ProductService {
    private final MyConnection myConnection;

    // Constructor mỗi khi khởi tạo 1 object
    // Tạo myConnection
    // MyConnection -> có function để kết nối tới database
    public ProductService() {
        myConnection = new MyConnection();
    }

    public void productFunction() {
        int chon;
        do {
            productMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_PRODUCT, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    List<Product> products = getAllProducts();
                    displayAllProduct(products);
                    break;
                case 2:
                    Product newProduct = inputProduct(); // -> Nhập từ bàn phím -> ko có error nhập
                    insertProduct(newProduct);
                    break;
                case 3:
                    String productCode = InputUtils.inputString("Nhập mã sản phẩm cần xóa: ");
                    deleteProduct(productCode);
                    break;
                case 5:
                    // Tìm kiếm sản phẩm theo ID
                    String inputId = InputUtils.inputString("Xin mời nhập id sản phẩm cần tìm:");
                    Product foundProduct = getProductById(inputId);
                    if (foundProduct == null) {
                        System.out.println("Không tìm thấy sản phẩm theo ID");
                        break;
                    }
                    displayProduct(foundProduct);
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
                    break;
            }
        } while (chon != LIMIT_MENU_PRODUCT);
    }

    public Product inputProduct() {
        ProductLineService productLineService = new ProductLineService();
        List<String> productLines = productLineService.getProductLinesName();

        String productCode = InputUtils.inputString("Nhập mã sản phẩm: ");
        String productName = InputUtils.inputString("Nhập tên sản phẩm: ");
        String productLine = InputUtils.inputString("Nhập dòng sản phẩm: [" + productLines.toString() + "]");
        // Nó sẽ đồng thời in ra các thông tin liên quan tới productLines trong database
        String productScale = InputUtils.inputString("Nhập scale: ");
        String productVendor = InputUtils.inputString("Nhập vendor: ");
        String productDescription = InputUtils.inputString("Nhập mô tả: ");
        int quantityInStock = InputUtils.inputDigit(1, 1_000_000, "Nhập số lượng: ");
        double buyPrice = InputUtils.inputDouble("Nhập giá mua: ");
        double MSRP = InputUtils.inputDouble("Nhập MSRP: ");
        return new Product(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
    }

    public void displayAllProduct(List<Product> products) {
        // Header
        displayProductHeader();
        for (Product product : products) {
            product.toDisplay();
        }
    }

    public void displayProduct(Product product) {
        displayProductHeader();
        product.toDisplay();
    }


    // GetByID -> trả về 1
    // GetAll -> Trả về 2
    // DisplayAll -> Hiển thị hết
    // display -> hiển thị 1
    public Product getProductById(String productCode) {
//        String query = "SELECT * FROM products WHERE productCode = '" + productCode + "'";
        // SQL Injection
        String query = "SELECT * FROM products WHERE productCode = ?";
        ResultSet resultSet = null;
        try (Connection connection = myConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, productCode);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String prdCode = resultSet.getString("productCode");
                String prdName = resultSet.getString("productName");
                String prdLine = resultSet.getString("productLine");
                String prdScale = resultSet.getString("productScale");
                String prdVendor = resultSet.getString("productVendor");
                String prdDescription = resultSet.getString("productDescription");
                int prdQty = Integer.parseInt(resultSet.getString("quantityInStock"));
                double prdPrice = Double.parseDouble(resultSet.getString("buyPrice"));
                double prdMSRP = Double.parseDouble(resultSet.getString("MSRP"));
                // Tạo new Product
                return new Product(prdCode, prdName, prdLine, prdScale, prdVendor, prdDescription, prdQty, prdPrice, prdMSRP);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        } finally {
            myConnection.closeResultSet(resultSet, "getProductById");
        }
        return null; // Không tìm thấy theo ID
    }

    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection connection = myConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String prdCode = resultSet.getString("productCode");
                String prdName = resultSet.getString("productName");
                String prdLine = resultSet.getString("productLine");
                String prdScale = resultSet.getString("productScale");
                String prdVendor = resultSet.getString("productVendor");
                String prdDescription = resultSet.getString("productDescription");
                int prdQty = Integer.parseInt(resultSet.getString("quantityInStock"));
                double prdPrice = Double.parseDouble(resultSet.getString("buyPrice"));
                double prdMSRP = Double.parseDouble(resultSet.getString("MSRP"));
                // Tạo new Product
                Product product = new Product(prdCode, prdName, prdLine, prdScale, prdVendor, prdDescription, prdQty, prdPrice, prdMSRP);
                result.add(product);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return result;
    }

    public void insertProduct(Product product) {
        if (product == null) {
            System.out.println("Product is null, can not be inserted");
            return;
        }

        String query = """
                INSERT INTO products (productCode, productName, productLine, 
                  productScale, productVendor, productDescription, 
                  quantityInStock, buyPrice, MSRP)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, product.getProductCode());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductLine());
            ps.setString(4, product.getProductScale());
            ps.setString(5, product.getProductVendor());
            ps.setString(6, product.getProductDescription());
            ps.setInt(7, product.getQuantityInStock());
            ps.setDouble(8, product.getBuyPrice());
            ps.setDouble(9, product.getMSRP());
            int row = ps.executeUpdate();

            System.out.println(" Product inserted: " + row);
        } catch (SQLException ex) {
            // xử lý error gì đấy
            System.out.println("Error: " + ex.getMessage()); // Ràng buộc giữa bảng product và productLines
            // Product tạo mới phải có cái trường productLine nằm trong bảng productLines
        }
    }

    public void deleteProduct(String productCode) {
        String query = """
                DELETE FROM products
                WHERE productCode = ?;
                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, productCode);
            int row = ps.executeUpdate();
            System.out.println("Product deleted: " + row);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
