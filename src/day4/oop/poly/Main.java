package day4.oop.poly;

public class Main {

    // Override
    // Ghi đè function
    //
    // Overloading
    // Một function, cùng tên, cùng kiểu trả về, và khác nhau về tham số.
    // Inheritance
    //

    Main(){
    }

    Main(String name){
    }

    Main(int age){
    }


    void display(String text){
        System.out.println(text);
    }

    void display(String text, String text2){
        System.out.println(text + " text2: " + text2);
    }
}
