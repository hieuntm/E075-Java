package day13.sample.service;

import day13.sample.db.MyConnection;

import java.sql.*;

public class AccountService {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        accountService.insertAccount();
    }

    public void insertAccount() {
        MyConnection myConnection = new MyConnection();
        String query = "INSERT INTO accounts (username, password) VALUES (?, ?)";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, "admin1");
            ps.setString(2, "admin1");

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) { // trả về key generated
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
            }

            System.out.println("abccccc");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
