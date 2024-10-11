package day2;

import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        // String la immutable, Bất biến
        String password = "abc123";
        String password3 = "abc123";
        String password2 = new String("abc123");
        System.out.println("So sánh passs: " + (password2 == password)); // false
        System.out.println("So sánh passs2: " + (password3 == password)); // true
        System.out.println("------");


        String testString = "Hello world";
        System.out.println("Contains: " + testString.contains("H")); // => Dung/ sai
        System.out.println("Contains: " + testString.contains("orl"));

        String testString2 = " ";
        System.out.println("Empty: " + testString2.isEmpty());
        System.out.println("Blank: " + testString2.isBlank());
        System.out.println("Length: " + testString2.length());

        String testString3 = "Green Academy";
        // testString3.concat("LA") => Return new value
        // New value # testString3
        testString3 = testString3.concat("LA");
        System.out.println("Concat: " + testString3);

        testString3 = testString3.toUpperCase();
        // Lowcase
        System.out.println("To uppercase: " + testString3);

        testString3.substring(3);
        // Cắt từ index 3 đến hết
        testString3 = testString3.substring(3, 7);
        // Cắt từ index 3 đến index 7
        System.out.println("After substring: " + testString3);

        // Nguyen Tri Minh Hieu
        // index 0 = Ho
        // last index = Ten
        // 0 -> last -> Ten dem
        String testString4 = "148 Nguyen Trai";
        System.out.println("Replace: " + testString4.replace("Trai", "Nguyen Trai, Hanoi"));

        String testString5 = "Hello        world,        I'm     from      the        void";
        String[] words = testString5.split("\\s+");
        for(int i = 0; i < words.length; i++)
            System.out.println(words[i]);
        System.out.println("Split: " + testString5);

//        Scanner sc = new Scanner(System.in);
//        String input;
//        System.out.println("Nhap password: ");
//        input = sc.nextLine();
//
//        System.out.println("Print: " + input);
//        System.out.println("So sánh: " + input.equals( password));
//        System.out.println("So sánh viết thường viết hoa: " + input.equalsIgnoreCase( password));

        String string = new String(); // immutable
        StringBuilder sb = new StringBuilder(); // mutable
        StringBuffer sbb = new StringBuffer(); // mutable
        // => Performance


        int so1 = 1;
        int so2 = 1;
        while(so1 + so2 < 1000){
            int so3 = so1 + so2;
            System.out.println("So: " + so3);
            so1 = so2;
            so2 = so3;
        }
    }
}
