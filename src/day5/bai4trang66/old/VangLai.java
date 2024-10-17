package day5.bai4trang66.old;

import java.util.Scanner;

public class VangLai extends Khach {
    private double phiThamGia;

    @Override
    void nhap() {
        // Hàm nhập, dùng để tự set data

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã passport: ");
        this.maPassport = sc.nextLine();
        System.out.println("Nhập tên: ");
        this.ten = sc.nextLine();
        System.out.println("Nhập tiền cược: ");
        this.tienCuoc = sc.nextDouble();
        System.out.println("Nhập phí tham gia: ");
        this.phiThamGia = sc.nextDouble();

        System.out.println("Nhập thành công!");
    }

    @Override
    public String toString() {
        return "VangLai{" +
                ", maPassport='" + maPassport + '\'' +
                ", ten='" + ten + '\'' +
                ", tienCuoc=" + tienCuoc + '\'' +
                "phiThamGia=" + phiThamGia +
                '}';
    }

    @Override
    void xuat() {
        System.out.println(this);
    }

    void tinhtienthang() {
        System.out.println("Tiền thưởng: " + (this.tienCuoc - this.phiThamGia));
    }

}
