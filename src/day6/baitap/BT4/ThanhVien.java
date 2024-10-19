package day6.baitap.BT4;

import java.util.Scanner;

public class ThanhVien extends KhachHang {
    private double tiLeThuong;

    public ThanhVien() {
        super();
    }

    public ThanhVien(String maPassport, String hoTen, double tienCuoc, double tiLeThuong) {
        super(maPassport, hoTen, tienCuoc);
        this.tiLeThuong = tiLeThuong;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ti le thuong: ");
        this.tiLeThuong = sc.nextDouble();
    }

    @Override
    public void xuat() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Thanh vien{" +
                "maPassport='" + maPassport + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tienCuoc=" + tienCuoc + '\'' +
                "ti le thuong=" + tiLeThuong +
                '}';
    }

    @Override
    public double tinhTienThang() {
        return tienCuoc * tiLeThuong;
    }
}
