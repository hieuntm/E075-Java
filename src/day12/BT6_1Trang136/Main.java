package day12.BT6_1Trang136;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        Lop lopA1 = new Lop("L02", "CNTT", 15);

        MonHoc monHoc1 = new MonHoc("M01", "Toán", 3, 1);

        Date today = new Date(System.currentTimeMillis());
        SinhVien sv1 = new SinhVien("SV01", "Nguyen Van A", today, "Ha Noi", lopA1.getMaLop(), "F");

        Diem diem1 = new Diem(sv1.getMssv(), lopA1.getMaLop(), 8.5F);

        System.out.println(lopA1);
        System.out.println(monHoc1);
        System.out.println(sv1);
        System.out.println(diem1);
    }
}
