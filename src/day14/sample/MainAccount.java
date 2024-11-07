package day14.sample;


import day13.sample.utils.InputUtils;
import day14.sample.service.AccountService;

public class MainAccount {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        int chon;
        do {
            menu();
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
                    accountService.insertAccount(accountName, password);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
            }
        } while (chon != 4);
    }

    public static void menu() {
        System.out.println("1. Đăng ký");
        System.out.println("2. Đăng nhập");
        System.out.println("3. Thoát");
    }
}
