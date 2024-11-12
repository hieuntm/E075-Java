package day16.sample.service;

import day16.sample.db.MyConnection;
import day16.sample.model.Account;
import day16.sample.model.Customer;
import day16.sample.model.Order;
import day16.sample.model.OrderDetail;
import day16.sample.model.cart.OrderedProduct;
import day16.sample.utils.InputUtils;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static day16.sample.utils.menu.UserMenuUitls.LIMIT_MENU_USER_ORDER;
import static day16.sample.utils.menu.UserMenuUitls.orderUserMenu;

public class OrderService {

    private final MyConnection myConnection;
    private final OrderDetailService orderDetailService;

    public OrderService() {
        myConnection = new MyConnection();
        orderDetailService = new OrderDetailService();
    }

    public void orderFunction(Account account, Customer customer) {
        String role = account.getRole();
        if (role.equalsIgnoreCase("admin")) {
//            adminFunction();
            // Tạo menu cho admin,
            // 1. Xem tất cả order của người dùng
            // 2. Xem chi tiết order
            // 3. Chuyển trạng thái order từ Ordered -> Shipped

            // Để test được data, thêm 1 user
            // rồi đặt hàng, nhiều đơn hàng,

            // tạo user khác, đặt đơn hàng tiếp
            // tạo 1 user khác, vào db chuyển role thành admin
            // test.
        } else {
            userFunction(customer);
        }
    }

    private void userFunction(Customer customer) {
        int chon;
        do {
            orderUserMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_USER_ORDER, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    // Hiển thị order đã đặt
                    showOrders(customer);
                    break;
                case 2:
                    // Hiển thị chi tiết order
                    // Nhập id order đơn hàng
                    int orderNumber = InputUtils.inputDigit(1, 100000, "Nhập order number: ");
                    Order foundOrder = findByOrderNumber(orderNumber);
                    if(foundOrder == null){
                        System.out.println("Order number không tồn tại");
                        break;
                    }
                    // tồn tại rồi, thì đi show các thông tin trong orders
                    // Khi đặt hàng -> Insert 1 record vào orders -> insert n records vào orderdetail
                    // muốn xem thông tin order thì -> lấy thông tin orderNumber để
                    // lấy về tất cả orderdetail -> lớn hơn 1 object
                    List<OrderDetail> orderDetails = orderDetailService.findByOrderNumber(orderNumber);
                    // bao gồm productCode, price, quantity
                    displayDetailOrder(foundOrder, orderDetails);
                    break;
                default:
                    System.out.println("-- Quay lại");
                    break;
            }
        } while (chon != LIMIT_MENU_USER_ORDER);
    }

    private void displayDetailOrder(Order foundOrder, List<OrderDetail> orderDetails){
        int orderNumber = foundOrder.getOrderNumber();
        String orderStatus = foundOrder.getStatus();

        System.out.println("Order Number: " + orderNumber + " - Status: " + orderStatus);
        // details
        for(OrderDetail orderDetail: orderDetails){
            orderDetail.display();
        }
    }

    private Order findByOrderNumber(int orderNumber){
        String query = "SELECT * FROM orders WHERE orderNumber = ?";
        ResultSet resultSet = null;
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    int orderNumberDB = rs.getInt("orderNumber");
                    Date orderDate = rs.getDate("orderDate");
                    Date requiredDate = rs.getDate("requiredDate");
                    Date shippedDate = rs.getDate("shippedDate");
                    String status = rs.getString("status");
                    String comments = rs.getString("comments");
                    return new Order(orderNumberDB, orderDate, requiredDate, shippedDate, status, comments);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return null;
    }

    private void showOrders(Customer customer) {
        String query = "SELECT * FROM orders WHERE customerNumber = ?";
        try (Connection connection = myConnection.connect();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customer.getCustomerNumber());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int orderNumber = rs.getInt("orderNumber");
                    String orderStatus = rs.getString("status");
                    System.out.println("Order Number: " + orderNumber + " - Status: " + orderStatus);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void insertOrder(Customer customer) {
        //customer chứa customerNumber  = account.id
        // customer chứa cart = snapshot cart hiện tại
//        ProductService productService = new ProductService(); // private hết rồi,
        String query = "INSERT INTO orders ( orderDate, " +
                "requiredDate, shippedDate, status, comments, customerNumber) " +
                "VALUES ( ?, ?, ?, ?, ?, ?)";
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
                if (rs.next()) { // Lấy key vừa tạo ra
//                    customer.getCart()
                    // Map -> chứa list key-value: productCode và quantity
                    for (Map.Entry<String, OrderedProduct> entry : customer.getCart().getCart().entrySet()) {
                        int newOrderKey = rs.getInt(1); // Key vừa tạo ra
                        String productCode = entry.getKey();
//                        Integer quantity = entry.getValue();
                        OrderedProduct orderedProduct = entry.getValue();
                        // priceEach., nó trong bằng product
                        orderDetailService.insertOrderDetails(newOrderKey,
                                productCode,
                                orderedProduct.getQuantity(),
                                orderedProduct.getPriceEach());
                        System.out.println("Inserted order details");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
