package day14.sample.service;

import day14.sample.db.MyConnection;
import day14.sample.utils.InputUtils;

import java.sql.*;

import static day14.sample.utils.MenuUtils.LIMIT_MENU_ACCOUNT;
import static day14.sample.utils.MenuUtils.accountMenu;

public class AccountService {

    private final MyConnection myConnection;

    public AccountService() {
        myConnection = new MyConnection();
        // new 1 object, object chứa function kết nối tới database
    }

    // Function chính, main của account, quản lý toàn bộ logic liên quan đến account
    public boolean accountFunction(){
        boolean isLogged = false;
        // Quan tâm đến việc đăng nhập -> đúng sai
        // Đăng ký xong thì lại bắt lại cái menu
        int chon;
        do {
            accountMenu();
            chon = InputUtils.inputDigit(1, 3, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    // Đăng ký account
                    System.out.println("Đăng ký account");
                    String accountName = InputUtils.inputString("Xin mời nhập account:");
                    String password = InputUtils.inputString("Xin mời nhập password:");
                    String rePassword = InputUtils.inputString("Xin mời nhập lại password:");
                    if (!password.equals(rePassword)) {
                        System.out.println("Password không trùng khớp");
                        break;
                    }
                    // register, signup
                    insertAccount(accountName, password);
                    break;
                case 2:
                    System.out.println("Đăng nhập: ");
                    String inputAccount = InputUtils.inputString("Xin mời nhập account:");
                    String inputPassword = InputUtils.inputString("Xin mời nhập password:");
                    isLogged = login(inputAccount, inputPassword);
                    // Đúng là đăng nhập thành công
                    // Sai là fail do mật khẩu, tài khoản
                    if (!isLogged) {
                        System.out.println("Đăng nhập thất bại");
                        break;
                    }
                    System.out.println("Đăng nhập thành công");
                    return true;
                default:
                    System.out.println("---------Thoát chương trình--------");
                    return false;
            }
        } while (chon != LIMIT_MENU_ACCOUNT);

        return isLogged;
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

    public boolean login(String username, String password) {
        System.out.println(username.length() + "" + password.length());
        // Kiểm tra username và password nó có cùng tồn tại trong database hay không
        // Nếu có thì trả về true, không thì trả về false
        // Select -> Lấy dữ liệu từ database
        // Update -> Sửa dữ liệu trong database
        // Delete -> Xoá khỏi database
        // Insert thêm dữ liệu vào database
        String query = "SELECT * FROM accounts WHERE username = ? AND password = ? ";
        ResultSet resultSet = null;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            resultSet = ps.executeQuery();
            // Username không trùng, thì không bao có 2 username giống nhau
            // if (resultSet.next()) -> trả về 1 bản ghi duy nhất (select 1)
            // while (resultSet.next()) -> trả về nhiều bản ghi (select nhiều)
            if (resultSet != null && resultSet.next()) { // Kiểm tra xem có dữ liệu về hay không
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            myConnection.closeResultSet(resultSet, "login");
        }
        return false; // Đăng nhập fail
    }

}
