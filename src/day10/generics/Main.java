package day10.generics;

public class Main {
    public static void main(String[] args) {

        GeneMath<Double> geneMath = new GeneMath<>(2d, 3d);

        System.out.println(geneMath.getNumber1());
        System.out.println(geneMath.getNumber2());

        // Dùng để kiểm tra xem biến có phải kiểu dữ liệu Double không
        System.out.println(geneMath.getNumber1() instanceof Double);

        // Tính tổng 2 số
        System.out.println(geneMath.add());

        GeneMath<String> geneText = new GeneMath<>("Hello", " ABCC");
        System.out.println(geneText.add());
    }
}
