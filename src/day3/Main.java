package day3;

public class Main {
    public static void main(String[] args) {
        // Function tao object tu class -> Ngta goi constructor
        // constructor: Ham khoi tao
        Terrorist terrorist = new Terrorist();
        // Tao lai object
        Terrorist terrorist1 = new Terrorist("String", 2d, 3d);

        System.out.println(terrorist.tostring());
        System.out.println(terrorist1);
    }
}
