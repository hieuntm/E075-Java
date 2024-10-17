package day5.bai4trang66.abstractclass;

import java.util.Scanner;

public class ThanhVien extends Khach {
    protected double tiLeThuong;

    @Override
    void nhap(){
        // Hàm nhập, dùng để tự set data

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã passport: ");
        this.maPassport = sc.nextLine();
        System.out.println("Nhập tên: ");
        this.ten = sc.nextLine();
        System.out.println("Nhập tiền cược: ");
        this.tienCuoc = sc.nextDouble();
        System.out.println("Nhập tỉ lệ thưởng: ");
        this.tiLeThuong = sc.nextDouble();

        System.out.println("Nhập thành công!");
    }

    @Override
    public String toString() {
        this.maPassport = this.maPassport == null ? "null" : this.maPassport;
        return "ThanhVien{" +
                ", maPassport='" + maPassport + '\'' +
                ", ten='" + ten + '\'' +
                ", tienCuoc=" + tienCuoc + '\'' +
                "tiLeThuong=" + tiLeThuong +
                '}';
    }

    @Override
    void xuat(){
        System.out.println(this);
    }

    void tinhtienthang(){
        System.out.println("Tiền thưởng: " + this.tienCuoc * this.tiLeThuong);
    }

}
