package day6.baitap.BT4;

import java.util.Scanner;

public class QuanLyKhachHang {

    private KhachHang[] danhsachKH;
    private int nextKH = 0;
    private int maxKH;


    public QuanLyKhachHang() {
        this.maxKH = 10;
        this.danhsachKH = new KhachHang[maxKH];
    }

    public QuanLyKhachHang(int maxKH) {
        this.maxKH = maxKH;
        this.danhsachKH = new KhachHang[maxKH];
    }


    private void addKH(KhachHang newKH) {
        if (nextKH == maxKH) {
            System.out.println("So luong khach hang da toi da.");
        }
        danhsachKH[nextKH++] = newKH;
        System.out.println("Them khach hang thanh cong.");
    }

    private void displayAllKH() {
        System.out.println("Danh sach khach hang: ");
        for (int i = 0; i < nextKH; i++) {
            System.out.println(danhsachKH[i]);
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Thêm khách thành viên");
            System.out.println("2. Thêm khách vãng lai");
            System.out.println("3. Hiển thị toàn bộ danh sách ( bao gồm tiền thắng cược )");
            System.out.println("4. Thoát chương trình");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    ThanhVien thanhvien = new ThanhVien();
                    thanhvien.nhap();
                    addKH(thanhvien);
                    break;
                case 2:
                    VangLai vanglai = new VangLai();
                    vanglai.nhap();
                    addKH(vanglai);
                    break;
                case 3:
                    displayAllKH();
                    break;
                case 4:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("---------Moi chon lai--------");
            }

        } while (chon != 4);

    }
}
