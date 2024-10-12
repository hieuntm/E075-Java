package day3.bt3;

public class Main {

    public static void main(String[] args) {
        HinhTamGiac htg = new HinhTamGiac(3, 4, 5);
//        System.out.println("Chu vi: " + htg.getChuVi());
//        System.out.println("Dien tich: " + htg.getDienTich());
        System.out.println(htg);
        htg.setMa(6);
        System.out.println(htg);


        HinhTamGiac htg2 = new HinhTamGiac(6, 8, 10);
        System.out.println(htg2);


//        HinhTamGiac htg2 = new HinhTamGiac(-1, 4, 5);

    }
}
