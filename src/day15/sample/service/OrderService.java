package day15.sample.service;

import day15.sample.db.MyConnection;
import day15.sample.model.Customer;

import java.sql.*;
import java.util.Map;

public class OrderService {

    private final MyConnection myConnection;

    public OrderService() {
        myConnection = new MyConnection();
    }

    public void insertOrder(Customer customer) {
        //customer chứa customerNumber  = account.id
        // customer chứa cart = snapshot cart hiện tại
        OrderDetailService orderDetailService = new OrderDetailService();
        String query = "INSERT INTO orders ( orderDate, requiredDate, shippedDate, status, comments, customerNumber) VALUES ( ?, ?, ?, ?, ?, ?)";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new Date(System.currentTimeMillis()));
            ps.setDate(2, new Date(System.currentTimeMillis()));
            ps.setDate(3, new Date(System.currentTimeMillis()));
            ps.setString(4, "Ordered");
            ps.setString(5, "No Comment");
            ps.setInt(6, customer.getCustomerNumber());
            ps.executeUpdate();

            // Lấy ra key từ bảng order sau khi insert vào
            // và đồng insert thêm vào order details
            try (ResultSet rs = ps.getGeneratedKeys()) { // trả về key generated
                if (rs.next()) {
//                    customer.getCart()
                    // Map -> chứa list key-value: productCode và quantity
                    for (Map.Entry<String, Integer> entry : customer.getCart().getCart().entrySet()) {
                        orderDetailService.insertOrderDetails(rs.getInt(1), entry.getKey(), entry.getValue(), 123);
                        System.out.println("Inserted order details");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
