package day6.baitap.BT3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeCollection listshape = new ShapeCollection();
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int chon;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Thêm hình tròn");
            System.out.println("2. Thêm hình chữ nhật");
            System.out.println("3. Xuất toàn bộ thông tin các hình học");
            System.out.println("4. Thoát chương trình");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    Circle circle = new Circle(random.nextDouble(100));
                    listshape.AddCircle(circle);
                    break;
                case 2:
                    Rectangle rectangle = new Rectangle(
                            random.nextDouble(100),
                            random.nextDouble(100));
                    listshape.AddRectangle(rectangle);
                    break;
                case 3:
                    listshape.show();
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
