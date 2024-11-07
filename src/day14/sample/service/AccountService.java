package day14.sample.service;

import day14.sample.db.MyConnection;

import java.sql.*;

public class AccountService {

    private final MyConnection myConnection;

    public AccountService() {
        myConnection = new MyConnection();
        // new 1 object, object chứa function kết nối tới database
    }

    // Insert account, đồng insert cả customers
    public void insertAccount(String username, String password) {
        String query = "INSERT INTO accounts (username, password) VALUES (?, ?)";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, username); // add cố định
            ps.setString(2, password);

            ps.executeUpdate(); // Trả về row affected
            System.out.println("Tạo account thành công");

            try (ResultSet rs = ps.getGeneratedKeys()) { // trả về key generated
                if (rs.next()) {
                    // Lấy id từ accounts vừa insert rs.getInt(1) -> insert thêm 1 records vào bảng customer nữa
                    System.out.println("Id account mới: " + rs.getInt(1));
                    // account id của table account
                    // mình lấy id này, mình insert vào bảng customer
                    CustomerService customerService = new CustomerService();
                    customerService.insertNewCustomer(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
