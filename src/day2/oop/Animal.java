package day2.oop;

class Animal {

    int weight;
    int height;
    String name;
    String species;
    // Thuoc tinh/ Fields/ Properties
    // => Cang nhieu => Cang nhieu tinh nang

    void an(){
        weight +=10;
    }

    void display(){
        System.out.println("------------------");
        System.out.println("Ten la: " +name);
        System.out.println("Can nang la: " +weight);
        System.out.println("Chieu cao la: " +height);
        System.out.println("Loai la: " +species);

    }

    void sleep(){

    }
    // Hanh vi cua animal
    // Methods/ Functions

}
