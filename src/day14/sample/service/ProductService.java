package day14.sample.service;

import day14.sample.db.MyConnection;
import day14.sample.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// ProductManagement
public class ProductService {
    private final MyConnection myConnection;

    // Constructor mỗi khi khởi tạo 1 object
    // Tạo myConnection
    // MyConnection -> có function để kết nối tới database
    public ProductService() {
        myConnection = new MyConnection();
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
            System.out.println("Error: " + ex.getMessage());
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
