package day16.sample.service;

import day16.sample.db.MyConnection;
import day16.sample.model.OrderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailService {

    private final MyConnection myConnection;

    public OrderDetailService() {
        myConnection = new MyConnection();
    }

    public List<OrderDetail> findByOrderNumber(int orderNumber) {
        // Bản chất là đi select * where 1 đk
        List<OrderDetail> result = new ArrayList<>();
        ResultSet resultSet = null;
        String query = "SELECT productCode, priceEach, orderLineNumber, quantityOrdered FROM orderdetails where orderNumber = ?";
        try (Connection connection = myConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderNumber);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String prdCode = resultSet.getString("productCode");
                double priceEach = Double.parseDouble(resultSet.getString("priceEach"));
                int quantityOrdered = Integer.parseInt(resultSet.getString("quantityOrdered"));
                int orderLineNumber = Integer.parseInt(resultSet.getString("orderLineNumber"));

                OrderDetail orderDetail = new OrderDetail(prdCode, quantityOrdered, priceEach, orderLineNumber);
                result.add(orderDetail);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            myConnection.closeResultSet(resultSet, "findByOrderNumber");
        }
        return result;
    }

    public void insertOrderDetails(int orderNumber, String productCode, int quantityOrdered, double priceEach) {
        String query = "INSERT INTO orderdetails (orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderNumber);
            ps.setString(2, productCode); // productCode
            ps.setInt(3, quantityOrdered); //quantityOrdered
            ps.setDouble(4, priceEach); // priceEach
            ps.setInt(5, 1); // orderLineNumber
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
