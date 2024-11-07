package day14.sample.utils;

public class MenuUtils {

    public static final int LIMIT_MENU_ACCOUNT = 3;
    public static final int LIMIT_MENU_PRODUCT = 7;

    public static void accountMenu() {
        System.out.println("1. Đăng ký");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Thoát");
    }

    // static thuộc về class, không phải thuộc về object
    // nên là nếu mà thuộc về object thì phải khởi tạo new
    // chúng ta có truy cập trực tiếp từ mọi nơi, với điều kiện là public
    public static void productMenu(){
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Update sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo ID");
        System.out.println("6. Thêm sản phẩm vào giỏ hàng");
        System.out.println("7. Thoát");
    }

    public static void displayProductHeader() {
        // Header
        System.out.println("-- Product list: --");
        System.out.printf("%20s%50s%20s%12s%25s%18s%12s\n", "Code", "Name", "prdLine", "Scale", "Vendor", "Quantity", "Buy Price");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
