package day15.sample.service;

import day15.sample.db.MyConnection;
import day15.sample.model.Account;
import day15.sample.model.Product;
import day15.sample.utils.InputUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static day15.sample.utils.HeaderDisplayUtils.displayProductHeader;
import static day15.sample.utils.menu.AdminMenuUitls.LIMIT_MENU_ADMIN_PRODUCT;
import static day15.sample.utils.menu.AdminMenuUitls.productAdminMenu;
import static day15.sample.utils.menu.UserMenuUitls.LIMIT_MENU_USER_PRODUCT;
import static day15.sample.utils.menu.UserMenuUitls.productUserMenu;

// ProductManagement
public class ProductService {
    private final MyConnection myConnection;

    // Constructor mỗi khi khởi tạo 1 object
    // Tạo myConnection
    // MyConnection -> có function để kết nối tới database
    public ProductService() {
        myConnection = new MyConnection();
    }

    public void productFunction(Account account) {
        String role = account.getRole();
        if (role.equalsIgnoreCase("admin")) {
            adminFunction();
        } else {
            userFunction();
        }
    }

    private void userFunction() {
        int chon;
        do {
            productUserMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_USER_PRODUCT, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    List<Product> products = getAllProducts();
                    displayAllProduct(products);
                    break;
                case 2:
                    // Tìm kiếm sản phẩm theo ID
                    String inputId = InputUtils.inputString("Xin mời nhập id sản phẩm cần tìm:");
                    Product foundProduct = getProductById(inputId);
                    if (foundProduct == null) {
                        System.out.println("Không tìm thấy sản phẩm theo ID");
                        break;
                    }
                    displayProduct(foundProduct);
                    break;
                case 3:
                    // Thêm vào giỏ hàng
                    break;
                default:
                    System.out.println("-- Quay lại");
                    break;
            }
        } while (chon != LIMIT_MENU_USER_PRODUCT);
    }

    private void adminFunction() {
        int chon;
        do {
            productAdminMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_ADMIN_PRODUCT, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    List<Product> products = getAllProducts();
                    displayAllProduct(products);
                    break;
                case 2:
                    Product newProduct = inputProduct(); // -> Nhập từ bàn phím -> ko có error nhập
                    Product existedProduct = getProductById(newProduct.getProductCode()); // -> lấy từ database
                    // Object mình lưu ở java code
                    if (existedProduct != null) {
                        System.out.println("Id đã tồn tại");
                        break;
                    }
                    insertProduct(newProduct);
                    break;
                case 3:
                    String productCode = InputUtils.inputString("Nhập mã sản phẩm cần xóa: ");
                    Product deleteProduct = getProductById(productCode);
                    // Object mình lưu ở java code
                    if (deleteProduct == null) {
                        System.out.println("Không tìm thấy sản phẩm theo ID");
                        break;
                    }
                    deleteProduct(productCode);
                    break;
                case 4:
                    String inputId4 = InputUtils.inputString("Xin mời nhập id sản phẩm cần sửa:");
                    Product foundProduct4 = getProductById(inputId4);
                    // Object mình lưu ở java code
                    if (foundProduct4 == null) {
                        System.out.println("Không tìm thấy sản phẩm theo ID");
                        break;
                    }
                    // test id: S10_4757
//                    foundProduct - Nằm trong database
                    // - sử dụng câu lệnh update, để sửa lại data trong database
                    // sửa bằng cách nhập từ bàn phím vào, và sử dụng setter để sửa
                    // bài tập là chỉ update name và price
                    String newName = InputUtils.inputString("Nhập tên cần sửa: ");
                    double newPrice = InputUtils.inputDouble("Nhập giá mới: ");
                    updateProduct(inputId4, newName, newPrice);
                    // Sau này bài toán có thể mở rộng ra, chúng ta cần update nhiều 2 trường
                    break;
                default:
                    System.out.println("-- Quay lại");
                    break;
            }
        } while (chon != LIMIT_MENU_ADMIN_PRODUCT);
    }

    // nhập mới -> tạo mới
    private Product inputProduct() {
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

    // display
    private void displayAllProduct(List<Product> products) {
        // Header
        displayProductHeader();
        for (Product product : products) {
            product.toDisplay();
        }
    }

    private void displayProduct(Product product) {
        displayProductHeader();
        product.toDisplay();
    }

    // update -> sửa
    private void updateProduct(String productCode, String newName, double newPrice) {
        String query = """
                UPDATE products
                SET productName = ?, buyPrice = ?
                WHERE productCode = ?;
                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newName);
            ps.setDouble(2, newPrice);
            ps.setString(3, productCode);
            ps.executeUpdate();
            System.out.println("Product với id: " + productCode + " đã được update: ");
        } catch (SQLException ex) {
            System.out.println("Lỗi update product: " + ex.getMessage());
        }
    }

    // getById -> get1
    // GetByID -> trả về 1
    // GetAll -> Trả về 2
    // DisplayAll -> Hiển thị hết
    // display -> hiển thị 1
    private Product getProductById(String productCode) {
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

    // getAll -> lấy nhiều
    // sau này có thể mở rộng thêm là lấy theo paging, tức là phân trang
    // giả sử chúng nó khoảng 1000 product
    // chia thành 30 trang hoặc giới hạn 1 trang có 30 sản phẩm
    // => 1000/30 = 33 trang
    private List<Product> getAllProducts() {
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

    // tạo mới -> create
    private void insertProduct(Product product) {
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

    // xoá -> delete
    private void deleteProduct(String productCode) {
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
