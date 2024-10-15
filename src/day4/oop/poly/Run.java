package day4.oop.poly;

public class Run {
    public static void main(String[] args) {
        Main m = new Main();
        Main m2 = new Main("Hello X");
        Main m3 = new Main(1);

        m.display("Hello");
        m.display("Hello", "World");

        System.out.println(123);
        System.out.println(123L);
        System.out.println(123D);
        System.out.println("123");
        System.out.println('c');
        System.out.println(true);
        System.out.println(m);

    }
}
