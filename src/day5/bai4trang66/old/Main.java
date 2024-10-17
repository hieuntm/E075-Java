package day5.bai4trang66.old;

public class Main {

    public static void main(String[] args) {
        Khach[] khach = new Khach[2];
        VangLai x = new VangLai();
        x.nhap(); // => Sinh ra data cho thằng x
        khach[0] = x;
        khach[1] = new ThanhVien();

//        ThanhVien[] abc = new Khach[2];
    }
}
