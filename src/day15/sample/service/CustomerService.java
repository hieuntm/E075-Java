package day15.sample.service;

import day15.sample.db.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerService {

    private final MyConnection myConnection;

    public CustomerService() {
        myConnection = new MyConnection();
    }

    public void insertNewCustomer(int customerNumber) {
        String query = "INSERT INTO customers (customerNumber) VALUES (?)";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customerNumber);

            ps.executeUpdate(); // Trả về row affected

            System.out.println("Tạo mới customer thành công");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
