package day14.sample.service;

import day14.sample.db.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductLineService {

    private final MyConnection myConnection;

    public ProductLineService() {
        myConnection = new MyConnection();
    }


    // Statement statement-> connection.createStatement
    //                     -> statement.executeQuery(query)
    // PrepareStatement -> connection.preparedStatement(query)

    // executeQuery -> select
    // executeUpdate -> insert, update, delete

    public List<String> getProductLinesName() {
        List<String> productLines = new ArrayList<>();
        String query = "SELECT productLine FROM productlines";
        try (Connection connection = myConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query);) {

            while(rs.next()) {
                String productLine = rs.getString(1);
                productLines.add(productLine);
            }

            System.out.println("Lấy Product Lines thành công");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return productLines;
    }
}
