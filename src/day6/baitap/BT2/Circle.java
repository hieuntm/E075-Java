package day6.baitap.BT2;

import java.util.Random;
import java.util.Scanner;

public class Circle extends Point implements Shape {
    double radius;
    int color;

    public Circle() {
        super();
    }

    public Circle(int x, int y, double radius, int color) {
        this.X = x;
        this.Y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Hình tròn có tọa độ (" + X + "," + Y + ")");
        System.out.println("Bán kính: " + radius);
        System.out.println("Màu: " + color);
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Circle circle = null;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Tạo hình tròn");
            System.out.println("2. Tạo ngẫu nhiên");
            System.out.println("3. Di chuyển hình tròn");
            System.out.println("4. Vẽ hình tròn");
            System.out.println("5. Tính diện tích hình tròn");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tọa độ x: ");
                    int x = sc.nextInt();

                    System.out.print("Nhập tọa độ y: ");
                    int y = sc.nextInt();

                    System.out.print("Nhập bán kính: ");
                    double radius = sc.nextDouble();

                    System.out.print("Nhập mã màu: ");
                    int color = sc.nextInt();
                    circle = new Circle(x, y, radius, color);
                    break;

                case 2:
                    Random random = new Random();

                    // Random
                    double radiusR = random.nextDouble(100);
                    int xR = random.nextInt(100);
                    int yR = random.nextInt(100);
                    int colorR = random.nextInt(255);

//                    int x1 = random.nextInt(7); // bản chất là mình dùng random để nó
                    // trả về giá trị từ 0 -> 6, tương ứng với index của 2 array trên
                    // Mình đang muốn lấy random 1 index trong colors
                    // random 2 index trong mảng int -> X và y
                    // random 1 bán kính
                    circle = new Circle(xR, yR, radiusR, colorR);
                    break;
                case 3:
                    if (circle == null) {
                        System.out.println("Hinh tron chua duoc tao");
                        return;
                    }
                    System.out.println("Nhap toa do dX:");
                    int dx = sc.nextInt();
                    System.out.println("Nhap toa do dY: ");
                    int dy = sc.nextInt();
                    circle.move(dx, dy);
                    break;
                case 4:
                    if (circle == null) {
                        System.out.println("Hinh tron chua duoc tao");
                        return;
                    }
                    circle.draw();
                    break;
                case 5:
                    if (circle == null) {
                        System.out.println("Hinh tron chua duoc tao");
                        return;
                    }
                    System.out.println("Dien tich hinh tron la: " + circle.area());
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("------Moi chon lai-----");
            }
        } while (choice != 6);
    }
}
