package day6.baitap.BT4;

import java.util.Scanner;

public class VangLai extends KhachHang {
    private double phiThamGia;

    public VangLai() {
        super();
    }

    public VangLai(String maPassport, String hoTen, double tienCuoc, double phiThamGia) {
        super(maPassport, hoTen, tienCuoc);
        this.phiThamGia = phiThamGia;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phi tham gia: ");
        this.phiThamGia = sc.nextDouble();
    }

    @Override
    public void xuat() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "VangLai{" +
                "maPassport='" + maPassport + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tienCuoc=" + tienCuoc + '\'' +
                "phiThamGia=" + phiThamGia +
                '}';
    }

    @Override
    public double tinhTienThang() {
        return tienCuoc - phiThamGia;
    }
}
