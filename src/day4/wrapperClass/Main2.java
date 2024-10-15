package day4.wrapperClass;

import day4.baitap3.NhanVien;

public class Main2 {

    public static void main(String[] args) {

        int[] arr = new int[10];
        int[] arr2 = {1, 2, 3, 4, 5};

        NhanVien nv1 = new NhanVien("1", 23);
        NhanVien nv2 = new NhanVien("2", 89);

        NhanVien[] nhanViens = new NhanVien[5];
        nhanViens[0] = nv1;
        nhanViens[1] = nv2;

        NhanVien[] nhanViens2 ={nv1, nv2};
        // Menu
        // 1. Them
        // 2. Update
        // 3. Xoa
        // 4. Sap xep
        // 5. Tim kiem
        // 6. Hien thi
        // 7. Thoat

    }
}
