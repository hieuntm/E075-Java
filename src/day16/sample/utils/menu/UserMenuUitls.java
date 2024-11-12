package day16.sample.utils.menu;

public class UserMenuUitls {

    public static final int LIMIT_MENU_USER = 4;

    // nằm ở main
    public static void userMenu() {
        System.out.println("1. Thông tin tài khoản"); // AccountService
        System.out.println("2. Thông tin giỏ hàng"); // productService
        System.out.println("3. Thông tin đơn hàng"); // orderService
        System.out.println("4. Thoát");
    }

    public static final int LIMIT_MENU_USER_ORDER = 3;

    // nằm ở product service
    public static void orderUserMenu() {
        System.out.println("1. Hiển thị order đã đặt");
        System.out.println("2. Hiển thị chi tiết order");
        System.out.println("3. Trở về");
    }


    public static final int LIMIT_MENU_USER_PRODUCT = 7;

    // nằm ở product service
    public static void productUserMenu() {
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Tìm kiếm sản phẩm theo ID");
        System.out.println("3. Thêm sản phẩm vào giỏ hàng"); // ->ngoài lề, liên quan đến cả order
        System.out.println("4. Xoá sản phẩm khỏi giỏ hàng");
        System.out.println("5. Đặt hàng");
        System.out.println("6. Xem giỏ hàng hiện tại" );
        System.out.println("7. Trở về");
    }

    // account_user_menu
    // account là function
    // user là role
    // menu là view
    public static final int LIMIT_MENU_USER_ACCOUNT = 3;

    // nằm ở account service
    public static void accountUserMenu(){
        System.out.println("1. Xem thông tin cá nhân");
        System.out.println("2. Cập nhật mật khẩu"); // => Sau này cần kết hợp với cả bảng Customer lôi thông tin cá nhân
        System.out.println("3. Trở về");
    }



}
