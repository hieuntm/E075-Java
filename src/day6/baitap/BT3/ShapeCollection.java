package day6.baitap.BT3;

import java.util.Scanner;

public class ShapeCollection {

    Scanner sc;
    Shape[] listshape;
    int count;

    public ShapeCollection() {
        listshape = new Shape[5];
        count = 0;
        sc = new Scanner(System.in);
    }

    public void AddCircle(Shape newCircle) {
        if (count == 5) {
            System.out.println("So luong da toi da.");
            return;
        }
        listshape[count++] = newCircle;
        System.out.println("Them hinh tron thanh cong");
    }

    public void AddRectangle(Shape newRectangle) {
        if (count == 5) {
            System.out.println("So luong da toi da.");
            return;
        }
        listshape[count++] = newRectangle;
        System.out.println("Them hinh chu nhat thanh cong");
    }

    public void show() {
        for (int i = 0; i < count; i++) {
            System.out.println(listshape[i]);
        }
    }
}
