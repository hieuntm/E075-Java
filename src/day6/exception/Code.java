package day6.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Code {


    public static void main(String[] args) {
        Code c = new Code();
        System.out.println(c.nhapSo(1,10));
    }

    // Có biến x
    // dùng sc nhập vào
    // Bài toán: Chỉ người dùng nhập vào 1 số
    // thì chương trình mới tiếp tục chạy
    // Nếu người dùng nhập ký tự /sai thì thông báo lỗi, và bắt người dùng nhập lại
    // Nhập đến khi nào đúng thì thôi

    // Giới hạn mức nhập giả sử 1 -> 5

    public static int nhapSo(int min, int max) {
        int n = -1;
        boolean flag;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhập số: ");
                n = sc.nextInt();
                if (!((n >= min) && (n <= max))) {
                    throw new InputMismatchException();
                }
                flag = true;
            } catch (InputMismatchException ex) {
                System.err.println("Nhập sai, nhập lại (" + min + " -> " + max + ")");
                flag = false;
            }
            // menu1. menu2 -> menu7
        } while (!flag); // Điều kiện ở đây, nó phải khác với điều kiện mà mình muốn

        // Lấy ký tự nhập vào
        // Dùng hàm parse, để nó parse thành số integer
        // nếu không parse được thì nó bảo ra lỗi ParseException

        return n;
    }


    // Check email
    // Check date
    // Check chính xác String là 3
//    public int nhapSo(){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Nhập số: ");
//        int n = -1;
//        try{
//            n = sc.nextInt();
//        }catch(InputMismatchException ex){
//            System.out.println("Nhập sai, nhập lại");
//            n = nhapSo();
//        }
//        // Lấy ký tự nhập vào
//        // Dùng hàm parse, để nó parse thành số integer
//        // nếu không parse được thì nó bảo ra lỗi ParseException
//
//        return n;
//    }


}
