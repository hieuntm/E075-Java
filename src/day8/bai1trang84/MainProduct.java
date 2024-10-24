package day8.bai1trang84;

import day8.bai1trang84.management.ProductManagement;
import day8.bai1trang84.util.InputUtils;

public class MainProduct {

    public static void main(String[] args) {
        ProductManagement prdManagement = new ProductManagement();
        int chon;
        do {
            menu();
            chon = InputUtils.inputDigit(1, 10, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    // trả về void
                    prdManagement.addProduct();
                    break;
                case 2:
                    // trả về true false
                    boolean isFound = prdManagement.searchById();
                    // Cách 1
//                    if(isFound){
//                        System.out.println("Tìm thấy sản phẩm");
//                    } else {
//                        System.out.println("Không tìm thấy sản phẩm");
//                    }
                    // Cách 2
                    System.out.println(isFound ? "Tìm thấy sản phẩm" : "Không tìm thấy sản phẩm");
                    break;
                case 3:
                    prdManagement.displayProduct(prdManagement.getPrList());
                    break;
                case 4:
                    prdManagement.deleteProduct();
                    break;
                case 5:
                    prdManagement.displaySingleProductById();
                    break;
                case 6:
                    prdManagement.sort(true);
                    break;
                case 7:
                    prdManagement.sort(false);
                    break;
                case 8:
                    prdManagement.updateProduct();
                    break;
                case 9:
                    prdManagement.displayProductByPriceRange();
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
            }
        } while (chon != 10);
    }

    public static void menu() {
        System.out.println("1. Tạo product");
        System.out.println("2. Tìm kiếm product theo id trả về đúng sai");
        System.out.println("3. Hiển thị danh sách product");
        System.out.println("4. Xoá sản phẩm theo id");
        System.out.println("5. Tìm kiếm product theo id trả về thông tin");
        System.out.println("6. Sắp xếp product theo giá tăng dần");
        System.out.println("7. Sắp xếp product theo giá giảm dần");
        System.out.println("8. Sửa thông tin product theo id");
        System.out.println("9. Hiển thị product theo khoảng giá");
        System.out.println("10. Thoát");
    }
}
