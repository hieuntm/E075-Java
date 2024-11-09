package day15.sample;


import day15.sample.model.Account;
import day15.sample.service.AccountService;
import day15.sample.service.ProductService;
import day15.sample.utils.InputUtils;

import static day15.sample.utils.menu.AdminMenuUitls.LIMIT_MENU_ADMIN;
import static day15.sample.utils.menu.AdminMenuUitls.adminMenu;
import static day15.sample.utils.menu.UserMenuUitls.LIMIT_MENU_USER;
import static day15.sample.utils.menu.UserMenuUitls.userMenu;

public class Main {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        ProductService productService = new ProductService();

        //  Function nào chỉ dùng ở trong class, thì nên private, nếu mà dùng hơn 2 lần thì mới nên public
        // Giới hạn quyền sử dụng function đó

        Account isLoggedAccount = accountService.loginAndSignupFunction();
        System.out.println("isLogged: " + isLoggedAccount);
        // Đến đoạn này là người dùng đã đăng nhập vào hệ thống
        // Từ đây, mình phân quyền người dùng
        // Admin -> Quản lý product, account, order
        // User -> Xem product, tạo order, thêm sản phẩm vào giỏ hàng, cập nhật thông tin account

        String role = isLoggedAccount.getRole();
        if (role.equals("admin")) {
            admin(accountService, isLoggedAccount, productService);
        } else if (role.equals("user")) {
            user(accountService, isLoggedAccount, productService);
        } else {
            System.out.println("Không xác định được role");
        }
    }


    private static void user(AccountService accountService,
                             Account loggedAccount,
                             ProductService productService) {
        int chon;
        do {
            userMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_USER, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    accountService.accountFunction(loggedAccount);
                    break;
                case 2:
                    productService.productFunction(loggedAccount);
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
                    break;
            }
        } while (chon != LIMIT_MENU_USER);
    }

    private static void admin(AccountService accountService,
                              Account loggedAccount,
                              ProductService productService) {
        int chon;
        do {
            adminMenu();
            chon = InputUtils.inputDigit(1, LIMIT_MENU_ADMIN, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    productService.productFunction(loggedAccount);
                    break;
                case 2:
                    accountService.accountFunction(loggedAccount);
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
                    break;
            }
        } while (chon != LIMIT_MENU_ADMIN);
    }


}
