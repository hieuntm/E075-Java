package day2.oop;

public class Main {

    public static void main(String[] args) {
//        int[] arr = new int[5];
//
//        Animal pig = null;
//        System.out.println(pig);
//
//        Animal cat = new Animal();
//        cat.display();
//        cat.an();
//        cat.sleep();

        Animal dog = new Animal();
        dog.height = 1;
        dog.weight = 30;
        dog.name = "Tom";
        dog.species = "Golden";

        dog.display();
        dog.an();
        dog.display();
    }
}
