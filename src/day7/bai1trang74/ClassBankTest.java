package day7.bai1trang74;

import day6.baitap.BT4.ThanhVien;
import day6.baitap.BT4.VangLai;

import java.util.Scanner;

public class ClassBankTest {

    // static method là function được cấp bộ nhớ trước rồi, có thể sử dụng trực tiếp
    // mà không cần phải sử dụng new

    // non-static method, để mà dùng được thì phải thông qua việc tạo object
    // thông qua hàm new
    public static void main(String[] args) {
        ClassBankTest nganHang = new ClassBankTest();
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
//            nganHang.menu();
            menuStatic();

            chon = InputUtils.nhapSo(1, 4, "Xin bạn chọn: ");
            switch (chon) {
                case 1:
                    bank.createAccount();
                    break;
                case 2:
                    bank.draw();
                    break;
                case 3:
                    bank.deposite();
                    break;
                default:
                    System.out.println("---------Thoát chương trình--------");
            }
        } while (chon != 4);
    }

    // non-static
    public void menu(){
        System.out.println("1. Tạo account");
        System.out.println("2. Rút tiền");
        System.out.println("3. Nạp tiền");
        System.out.println("4. Thoát");
    }

    // non-static
    public static void menuStatic(){
        System.out.println("1. Tạo account");
        System.out.println("2. Rút tiền");
        System.out.println("3. Nạp tiền");
        System.out.println("4. Thoát");
    }
}
