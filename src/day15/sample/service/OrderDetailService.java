package day15.sample.service;

import day15.sample.db.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailService {

    private final MyConnection myConnection;

    public OrderDetailService() {
        myConnection = new MyConnection();
    }

    public void insertOrderDetails(int orderNumber, String productCode, int quantityOrdered, double priceEach) {
        String query = "INSERT INTO orderdetails (orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderNumber);
            ps.setString(2, productCode);
            ps.setInt(3, quantityOrdered);
            ps.setDouble(4, priceEach);
            ps.setInt(5, 1);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
