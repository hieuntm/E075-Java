package day13.sample.service;

import day13.sample.db.MyConnection;
import day13.sample.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    // Lấy toàn bộ product
    // Lấy product theo ID
    // Lấy product theo tên
    // Lấy product theo giá
    // Lấy product theo danh mục
    // Muốn tính năng thì viết vào đây
    // Insert
    // Update -> CRUD -> Create/Read/Update/Delete
    // Sort -> Dùng query order by
    // Export ra file
    private final MyConnection myConnection;

    public ProductService() {
        myConnection = new MyConnection();
    }
    // Mỗi khi mà có function sử dụng database, tạo kết nối từ nó và đóng nó sau
    // khi sử dụng

    // Cách cũ
    // Get All -> Trả về 1 danh sách sản phẩm
    // Thì kiểu trả về, void -> List<Product>
//    public List<Product> getAllProducts() {
//        List<Product> result = new ArrayList<>();
//        Connection connection = myConnection.connect(); // Từ java 6 không cần close resource
//        Statement statement = null;
//        ResultSet resultSet = null;
//        try {
//            String query = "SELECT * FROM products";
//
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                String prdCode = resultSet.getString("productCode");
//                String prdName = resultSet.getString("productName");
//                String prdLine = resultSet.getString("productLine");
//                String prdScale = resultSet.getString("productScale");
//                String prdVendor = resultSet.getString("productVendor");
//                String prdDescription = resultSet.getString("productDescription");
//                int prdQty = Integer.parseInt(resultSet.getString("quantityInStock"));
//                int prdPrice = Integer.parseInt(resultSet.getString("buyPrice"));
//                int prdMSRP = Integer.parseInt(resultSet.getString("MSRP"));
//
//                // Tạo new Product
//                Product product = new Product(prdCode, prdName, prdLine, prdScale, prdVendor, prdDescription, prdQty, prdPrice, prdMSRP);
//                result.add(product);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error: " + ex.getMessage());
//        } finally {
//            // Sau khi sử dụng xong database thì phải đóng
//            // Phải đóng 3 cái
//            // connection, statement, resultset
//            // thứ tự đóng, thì cái nào mở trước thì đóng sau
//            // đóng trong finally -> Tức là dù m có bị error, bị vào exception thì cũng đóng
//            // Kiểm tra, nếu kết nối khác null, thì đóng
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error while closing to database");
//            }
//        }
//        return result;
//    }

    // Cách mới
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        String query = "SELECT * FROM products";
        // Select * nó nhiều dữ liệu quá,
        // Tính paging, phân trang
        // giả sử database có khoảng 20.000 dữ liệu
        // nếu mà load 1 lần lên thì tốn memory
        // mỗi 1 lần select chỉ select khoảng 500 bản ghi
        // Tính pageNumber, tính pageSize = 500
        // Sử dụng Offset và Limit trong query
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

    // PreparedStatement
    // 1 là insert, update, delete
    // Tất cả luôn

    public void insertProduct(Product product) {
        if(product == null){
            System.out.println("Product is null, can not be inserted");
            return;
        }

        String query = """
                                INSERT INTO products (productCode, productName, productLine, 
                                  productScale, productVendor, productDescription, 
                                  quantityInStock, buyPrice, MSRP)
                                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                                """;
        // Liệt kê toàn bộ fields
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            // index bắt đầu từ 1
            ps.setString(1, product.getProductCode());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductLine());
            ps.setString(4, product.getProductScale());
            ps.setString(5, product.getProductVendor());
            ps.setString(6, product.getProductDescription());
            ps.setInt(7, product.getQuantityInStock());
            ps.setDouble(8, product.getBuyPrice());
            ps.setDouble(9, product.getMSRP());
            // Nó put các giá trị vào trong query theo dấu ? tương đương

            int row = ps.executeUpdate(); // insert
            // Insert xong nó trả ra number of row affected
            // trả 1 số nguyên

            // Tại sao dùng PreparedStatement
            // 1 là concat string (cộng chuỗi) phức tạp
            // 2 là liên quan SQL Injection  -> Kiểu tấn công qua SQL
            // Chỉ sinh ra khi mà cộng chuỗi
            // 1 câu lệnh sql_safe_update = 0 -> chống update, xoá data
            // VD: Insert into ABC values ("+ productCode +", "+ productName +", ...)
            // Truyền productCode = -- ; DROP TABLE products; --
            // dấu -- có comment cái phần sau, ; kết thúc query -> xoá bảng
            // 3. Hiệu năng
            System.out.println(product.getProductCode() + " - Row affected: " + row);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    // Xoá sản phẩm
    public void deleteProduct(String productCode) {
        // Hệ thống chặt chẽ hơn
        // 1 là select theo productCode -> xem nó có dữ liệu không
        // Có thì xoá,
        // không thì báo là ko tồn tại
        String query = """
                                DELETE FROM products
                                WHERE productCode = ?;
                                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, productCode);

            int row = ps.executeUpdate(); // insert
            System.out.println("Row deleted: " + row);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
