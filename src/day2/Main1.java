package day2;

import java.util.Scanner;

public class Main1 {
    public static void main(String... arguments) {
        // ax+b = c;
        // ax2 + bx + c = 0
        // Nhap  a, b
        // Nhap a, b, c
        int a, b, c;

        // Default
        Scanner sc = new Scanner(System.in);
        // datatype identifier = new datatype()
        System.out.println("Nhap a: ");
        a = sc.nextInt();
        System.out.println("Nhap b: ");
        b = sc.nextInt();
        System.out.println("Nhap c: ");
        c = sc.nextInt();
        System.out.println("Phuong trinh la: " + a + "x + " + b + " = " + c);
        double x = (double) (c - b) / a;
        System.out.println("x = : " + x);

//        System.out.printf("Phuong trinh bac 2 la: %dx2 + %dx + %d = 0\n", a, b, c);
        System.out.println("Phuong trinh bac 2 la: " + a + "x2 + " + b + "x + " + c + " = 0");

        double delta = b * b - 4 * a * c;

    }
}










