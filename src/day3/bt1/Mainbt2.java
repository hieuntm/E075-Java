package day3.bt1;

import day3.bt2.Square;

public class Mainbt2 {

    public static void main(String[] args) {
        Square square = new Square();
        square.display(); // public
//         square.display2(); // default, khác chung package
//         square.display3(); // Error


    }

    // access modifier + return type/ kieu du kieu tra ve + name/ten ham + (parameter)
    // access modifier: public, private, protected, default
    // return type: void, int, double, String, ...
    // name: ten ham, tự đặt
    // parameter: tham số, có thể có hoặc không, và do mình tự định nghĩa
    // => Tạo ra tỷ function
}
