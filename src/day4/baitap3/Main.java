package day4.baitap3;

import java.util.Scanner;

public class Main {

    // arguments : Tham so truyen vao
    public static void main(String ...arguments) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten nhan vien: ");
        String name = sc.next();

        System.out.println("Nhap so SP: ");
        int soSP = sc.nextInt();

        NhanVien nv1 = new NhanVien(name, soSP);
        NhanVien nv2 = new NhanVien("NV2", 400);
        NhanVien nv3 = new NhanVien("NV3", 300);
        NhanVien nv4 = new NhanVien("NV4", 600);
        NhanVien nv5 = new NhanVien("NV5", 800);

        System.out.println(nv1);
        System.out.println(nv2);
        System.out.println(nv3);
        System.out.println(nv4);
        System.out.println(nv5);

    }
}
