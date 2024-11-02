package day12.jdbc;

import java.sql.*;

public class ConnectionDB {


    public static void main(String[] args) throws SQLException {
        Connection connection =
                // 3 tham số
                // 1 là url: jdbc:mysql://localhost:3306/qlsv -> qlsv tên database
                // 2 là username
                // 3 là password
                DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "<Thêm mật khẩu của bạn vào đây>");
        System.out.println(connection);

        String query = "select * from products"; // Tạo query
        Statement statement = connection.createStatement(); // Run query
        ResultSet resultSet = statement.executeQuery(query); // Hứng data

        //select * from" +" tenTB"
        // PreparedStatement preparedStatement = connection.prepareStatement("select * from products where productCode = ?"); // Tạo query

        // index param -> chống SQL Injection -> Kiểu tấn công mạng

        // Dùng while true, bởi vì nó ko biết có bao nhiêu kq trả về
        // Bản chất là mình loop hết cái resultSet để lấy hết data
        // nếu là result.next() = false thì nó sẽ dừng/ Tức là không có dữ liệu
        // và result set nó trả dữ liệu về dưới dạng bảng
        while (resultSet.next()) {
            // resultSet.getString("name") -> lấy dữ liệu theo tên cột, có viết hoa viết thường
            // resultSet.getString(1) -> lấy dữ liệu theo index cột/ index ở đây bắt đầu từ 1
//            System.out.println(resultSet.getString("productName"));
            String prdCode = resultSet.getString("productCode");
            String prdName = resultSet.getString("productName");
            String prdLine = resultSet.getString("productLine");


            String prdScale = resultSet.getString(4);
            String prdVendor = resultSet.getString(5);
            String prdDescription = resultSet.getString(6);

            System.out.println(prdCode + " - " + prdName + " - " + prdLine + " - " + prdScale + " - " + prdVendor);
        }

    }
}
