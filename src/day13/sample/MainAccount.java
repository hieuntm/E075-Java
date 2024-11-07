package day13.sample;


import day13.sample.model.Product;
import day13.sample.service.ProductService;
import day13.sample.utils.InputUtils;
import day14.sample.service.AccountService;

import java.util.Random;

public class MainAccount {

//    public static void main(String[] args) {
//        AccountService accountService = new AccountService();
//        int chon;
//        do {
//            menu();
//            chon = InputUtils.inputDigit(1, 3, "Xin bạn chọn: ");
//            switch (chon) {
//                case 1:
//                    // Đăng ký account
//                    accountService.insertAccount();
//                    break;
//                case 2:
//                    break;
//                default:
//                    System.out.println("---------Thoát chương trình--------");
//            }
//        } while (chon != 4);
//    }

    public static void menu() {
        System.out.println("1. Đăng ký");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Thoát");
    }
}
