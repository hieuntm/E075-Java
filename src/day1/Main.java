package day1;

import java.util.Scanner;

public class Main {

    //String ...args
    //String[] args


    // Tao ham main
    public static void main(String[] args) {
        // *
        // **
        // ***
        // ****
        // *****
        byte a = 127; // -128 -> 127
        short b = 20; // -32768 -> 32767
        char y = 'A'; // 0 -> 65535
        int x = 10; // -2^31 -> 2^31 - 1
        float w = 7.6f;
        double z = 10.5;
        boolean k = true; // false
        String s = "Hello";

        int g = 10 + 20;
        int h = 10 - 20;
        int ii = 10 * 20;
        int jj = 10 / 20;
        int l = 10 % 20;

        // >, <, >=, <=, ==, !=     ->       true/false
        boolean isTrue = 10 > 20; // false
        boolean isGreater10 = 5 >= 10; // false

        // &&, ||,
//        int m = 2;
//        switch (m) {
//            case 1:
//                System.out.println("M = 1");
//                break;
//            case 2:
//                System.out.println("M = 2");
//            case 3:
//                System.out.println("M = 3");
//                break;
//            default:
//                System.out.println("M = ?");
//        }


//        for(int i = 0; i < 5; i++) {
//            for(int j = 0; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        int mmm = 0;
//        while (mmm < 10) {
//            System.out.println("Hello");
//            mmm++;
//        }

        do{
            System.out.println("Hello");
            mmm++;
        } while (mmm < 10);


        // for: Chay biet truoc so lan lap
        // while: Chay khi khong biet truoc so lan lap
        // do while: Chay it nhat 1 lan, sau do chay khi dieu kien dung
        // -> for doi cho while
        // -> while co doi cho for (Trong 1 so truong hop)
        // -> do while co the thay the cho while

        // Trong array, index bat dau tu 0 -> n-1 (size - 1)
//        int arr11[5]; // 0, 1, 2, 3, 4 -> SAI CU PHAp
        int arr11[] = new int[5];
        arr11[0] = 10;
        arr11[1] = 20;
        arr11[2] = 30;
        arr11[3] = 40;
        arr11[4] = 50;
        arr11[4] = 50;

        int arr22[] = {10, 20, 30};
//        arr22[2] = 100; // Index boundary exception

//        int chia0 = 10 / 0;  //   ArithmeticException
        // Trong java, neu ma gap loi thi chuong trinh se dung lai
        // va no the hien loi do ra cho nguoi dung
        // -> Exception

        System.out.println(helloMyName());

        Scanner scanner = new Scanner(System.in);
        // Scanner -> Class
        // scanner -> ten bien/identifier
        // new Scanner(System.in) -> Khoi tao doi tuong scanner
        System.out.println("Enter your name: ");
        String myName = scanner.nextLine();
        System.out.println("Enter your age: ");
        double myAge = scanner.nextDouble();
        System.out.println("Hello From KeyBoard" + myName + ", age: " + myAge);
        System.out.println(String.format("Hello From KeyBoard %s, age: %f", myName, myAge));
    }

    int tinhToan(){
        return 10;
    }

    static String helloMyName(){
        return "Hello XYZZ";
    }

    double sum(double a, double b){
        if(a < 0 ){
        } else {
        }
        // a >= 0
        return a+b;
    }



}

