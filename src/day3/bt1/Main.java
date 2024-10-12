package day3.bt1; // Folder

import java.util.Scanner; // Folder java.util.Scanner

class Main {

    // Access modifier -> Phạm vi truy cập
    // public, private, protected, default(Không có)

    void display() {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
