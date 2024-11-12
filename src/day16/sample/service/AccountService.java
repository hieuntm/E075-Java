package day16.sample.service;

import day16.sample.db.MyConnection;
import day16.sample.model.Account;
import day16.sample.utils.InputUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static day16.sample.utils.HeaderDisplayUtils.displayAccountHeader;
import static day16.sample.utils.menu.AdminMenuUitls.LIMIT_MENU_ADMIN_ACCOUNT;
import static day16.sample.utils.menu.AdminMenuUitls.accountAdminMenu;
import static day16.sample.utils.menu.CommonMenuUtils.LIMIT_MENU_ACCOUNT;
import static day16.sample.utils.menu.CommonMenuUtils.loginMenu;
import static day16.sample.utils.menu.UserMenuUitls.LIMIT_MENU_USER_ACCOUNT;
import static day16.sample.utils.menu.UserMenuUitls.accountUserMenu;

public class AccountService {

    private final CustomerService customerService = new CustomerService();
    private final MyConnection myConnection;

    public AccountService() {
        myConnection = new MyConnection();
        // new 1 object, object chứa function kết nối tới database
    }

    // Function chính, main của account, quản lý toàn bộ logic liên quan đến account
    public Account loginAndSignupFunction() {
        Account isLogged = null;
        // Quan tâm đến việc đăng nhập -> đúng sai
        // Đăng ký xong thì lại bắt lại cái menu
        int chon;
        do {
            loginMenu();
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
                    isLogged = login(inputAccount, inputPassword); //isLogged = account
                    // Đúng là đăng nhập thành công
                    // Sai là fail do mật khẩu, tài khoản
                    if (isLogged == null) {
                        System.out.println("Đăng nhập thất bại");
                        break;
                    }
                    System.out.println("Đăng nhập thành công");
                    // phải return về thoát khỏi do while
                    return isLogged;
                default:
                    System.out.println("-- Quay lại");
                    break;
            }
        } while (chon != LIMIT_MENU_ACCOUNT);

        return isLogged;
    }

    public void accountFunction(Account account) {
        String role = account.getRole();
        if (role.equalsIgnoreCase("admin")) {
            adminFunction(account);
        } else {
            userFunction(account);
        }
    }

    private void adminFunction(Account account) {
        int chon;
        do {
            accountAdminMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_ADMIN_ACCOUNT, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    List<Account> accounts = findAllAccount();
                    displayAllAccount(accounts);
                    break;
                case 2:
                    String username = InputUtils.inputString("Nhập username cần tìm: ");
                    Account exsitedAccount = findByUsername(username); // -> lấy từ database
                    // Object mình lưu ở java code
                    if (exsitedAccount == null) {
                        System.out.println("Account không tồn tại");
                        break;
                    }
                    displayAccount(exsitedAccount);
                    break;
                case 3:
                    String usernameDelete = InputUtils.inputString("Nhập username cần tìm: ");
                    Account exsitedAccountDelete = findByUsername(usernameDelete); // -> lấy từ database
                    // Object mình lưu ở java code
                    if (exsitedAccountDelete == null) {
                        System.out.println("Account không tồn tại");
                        break;
                    }
                    deleteAccount(usernameDelete);
                    break;
                case 4:
                    updatePassword(account.getUsername());
                    break;
                default:
                    System.out.println("-- Quay lại");
                    break;
            }
        } while (chon != LIMIT_MENU_ADMIN_ACCOUNT);
    }

    private void userFunction(Account account) {
        int chon;
        do {
            accountUserMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_USER_ACCOUNT, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    displayAccount(account);
                    break;
                case 2:
                    updatePassword(account.getUsername());
                    break;
                default:
                    System.out.println("-- Quay lại");
                    break;
            }
        } while (chon != LIMIT_MENU_USER_ACCOUNT);
    }

    //
    private void updatePassword(String username) {
        String password = InputUtils.inputString("Nhập mật khẩu mới: ");
        String newPassword = InputUtils.inputString("Xác nhận lại mật khẩu: ");

        // Object mình lưu ở java code
        if (!password.equals(newPassword)) {
            System.out.println("Mật khẩu nhập lại không đúng");
            return;
        }
        updateAccountOnlyPassword(username, newPassword);
    }

    // của người dùng
    // Insert account, đồng insert cả customers
    private void insertAccount(String username, String password) {
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
                    customerService.insertNewCustomer(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // cả admin và user
    private Account login(String username, String password) {
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
                int id = resultSet.getInt("id");
                String usernameDB = resultSet.getString("username");
                String role = resultSet.getString("role");

                return new Account(id, usernameDB, role);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            myConnection.closeResultSet(resultSet, "login");
        }
        return null; // Đăng nhập fail
    }

    // CRUD
    // Các bước để tạo: Create, Read(FindById, findAll), Update, Delete
    // 1 là thiết kế function tìm bởi id, hoặc cột định danh nào đấy
    // 2 thiết kết các function CRUD
    // cả 4 cái trên, trừ cái read ra, còn lại đều cần phải sử dụng cái function findById
    // 1.2. Find all -> tìm kiếm tất cả
    // 3. Create: Cần tìm xem id nó đã tồn tại chưa, chưa thì insert, rồi thì báo lỗi
    // 4. Update: Tìm xem id nó tồn tai chưa, chưa thì mới báo lỗi, tồn tại rồi thì mới cho đi update
    // 5. Delete: Cần tìm xem id tồn tại chưa, chưa thì báo lỗi, tồn tại thì mới cho phép xoá
    // -> 1 Connection -> Statement (Select)/ PreparedStatement(Insert, Update, Delete)
    // linh hoạt tuỳ vào logic

    private void displayAllAccount(List<Account> accounts) {
        // Header
        displayAccountHeader();
        for (Account account : accounts) {
            account.toDisplay();
        }
    }

    private void displayAccount(Account acount) {
        displayAccountHeader();
        acount.toDisplay();
    }

    private List<Account> findAllAccount() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts";
        ResultSet resultSet = null;
        try (Connection connection = myConnection.connect();
             Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                accounts.add(new Account(id, username, role));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            myConnection.closeResultSet(resultSet, "findAllAccount");
        }
        return accounts;
    }

    private Account findByUsername(String usernameInput) {
        String query = "SELECT * FROM accounts WHERE username = ?";
        ResultSet resultSet = null;
        try (Connection connection = myConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, usernameInput);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                return new Account(id, username, role);
            }
        } catch (SQLException ex) {
            System.out.println("Error find account " + ex.getMessage());
        } finally {
            myConnection.closeResultSet(resultSet, "findByUsername");
        }
        return null; // Không tìm thấy theo ID
    }

    private void updateAccountOnlyPassword(String username, String password) {
        String query = """
                UPDATE accounts
                SET password = ?
                WHERE username = ?;
                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
            System.out.println("Account với username: " + username + " đã đổi mật khẩu: ");
        } catch (SQLException ex) {
            System.out.println("Lỗi update account: " + ex.getMessage());
        }
    }

    private void updateAccount(String username, String password, String role) {
        String query = """
                UPDATE accounts
                SET password = ?, role = ?
                WHERE username = ?;
                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, password);
            ps.setString(2, role);
            ps.setString(3, username);
            ps.executeUpdate();
            System.out.println("Account với username: " + username + " đã được update: ");
        } catch (SQLException ex) {
            System.out.println("Lỗi update account: " + ex.getMessage());
        }
    }

    private void deleteAccount(String username) {
        String query = """
                DELETE FROM accounts
                WHERE username = ?;
                """;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            int row = ps.executeUpdate();
            System.out.println("Account deleted: " + row);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
