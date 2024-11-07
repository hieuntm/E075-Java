package day14.sample;


import day14.sample.model.Account;
import day14.sample.service.AccountService;
import day14.sample.service.ProductService;

public class Main {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        ProductService productService = new ProductService();

        // CHương trình quản lý tổng
        // do
        // switch case:
        // case 1: quản lý product
        // case 2: quản lý account
        // case 3: quản lý order
        // while
        // By Pass Login - Kiểm thử, skip cái phần login
        Account isLoggedAccount = accountService.accountFunction();
        // Chứa thông tin account và quan trọng là role
        // Từ role -> quyết định chương trình đi theo hướng nào
//        boolean isLogged = true;
        System.out.println("isLogged: " + isLoggedAccount);

        if (isLoggedAccount != null) {
            productService.productFunction();
        }


//        if (isLogged) {
//            ProductService productService = new ProductService();
//            productService.displayAllProduct();
//        }
        // Thêm sản phẩm

        // Thanh toán

        // Kết thúc chương trình, hoặc lặp lại

    }


}
