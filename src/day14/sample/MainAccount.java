package day14.sample;


import day13.sample.utils.InputUtils;
import day14.sample.service.AccountService;
import day14.sample.service.ProductService;

import static day14.sample.utils.MenuUtils.accountMenu;

public class MainAccount {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        ProductService productService = new ProductService();

        // By Pass Login - Kiểm thử, skip cái phần login
//        boolean isLogged = accountService.accountFunction();
        boolean isLogged = true;
        System.out.println("isLogged: " + isLogged);

        if(isLogged){
            productService.productFunction();
        }


//        if (isLogged) {
//            ProductService productService = new ProductService();
//            productService.displayAllProduct();
//        }

    }


}
