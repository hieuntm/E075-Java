package day3.bt2;

public class Mainbt2 {

    public static void main(String[] args) {
        // ten biến/ identifier
        // 1. Chứa chữ cái, số, ký tự đặc biệt: _, $
        // 2. Không bắt đầu bằng số
        // 3. Không trùng với keyword của Java
        // 4. Quy tắc đặt tên: camelCase, PascalCase, snake_case
        // Kiểu dữ liệu - Data type = new Kiểu dữ liệu();
        Square square = new Square();
        square.display(); // public
        square.display2(); // default, dùng chung package
        // square.display3(); // Error


        System.out.println("String");
        System.out.println(123);
        System.out.println(123321.54);
        System.out.println(true);
        System.out.println('a');
        System.out.println(123 + 321);
        System.out.println(square);
    }
}
