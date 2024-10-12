package day3.bt1;

public class Main {

    public static void main(String[] args) {
        HCN hcn1 = new HCN();
        HCN hcn2 = new HCN(3, 6);

        hcn1.display();
        hcn1.chuVi();
        System.out.println("Diện tích: " + hcn1.dienTich());
        System.out.println("----------");
        hcn2.display();
        hcn2.chuVi();
        System.out.println("Diện tích: " + hcn2.dienTich());
    }
}
