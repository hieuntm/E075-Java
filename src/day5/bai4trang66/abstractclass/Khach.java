package day5.bai4trang66.abstractclass;

public abstract class Khach{

    protected String maPassport;
    protected String ten;
    protected double tienCuoc;

    // ghi đè or không
    void nhap(){

    }

    // ghi đè or không
    void xuat(){

    }

    // Phải ghi đè
    // abstract function == abstract method, phuong thuc.
    abstract void tinhtienthang();

}
