package day6.baitap.BT4;


import java.util.Scanner;

public class Main {
    KhachHang[] danhsachKH;
    int nextKH = 0;
    int maxKH;

    public Main(int maxKH) {
        this.maxKH = maxKH;
        danhsachKH = new KhachHang[maxKH];
    }

    public void addKH(KhachHang newKH) {
        if (nextKH == maxKH) {
            System.out.println("So luong khach hang da toi da.");
        }
        danhsachKH[nextKH++] = newKH;
        System.out.println("Them khach hang thanh cong.");
    }

    public void displayAllKH() {
        System.out.println("Danh sach khach hang: ");
        for (int i = 0; i < nextKH; i++) {
            System.out.println(danhsachKH[i]);
        }
    }

    public static void main(String[] args) {
        Main danhsachKH = new Main(10);
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
                    danhsachKH.addKH(thanhvien);
                    break;
                case 2:
                    VangLai vanglai = new VangLai();
                    vanglai.nhap();
                    danhsachKH.addKH(vanglai);
                    break;
                case 3:
                    danhsachKH.displayAllKH();
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
