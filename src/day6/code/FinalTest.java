package day6.code;

public class FinalTest {

    // final cho biến
    // final cho function
    // final cho class (class)

    private final String name = "Nguyen Van A";
    // name, là hằng số, không thay đổi được

//        name = "ABC"; // => Error


    private final void abc(){
        System.out.println("ABC");
    }
    // đây là 1 hàm không thể override được.

    final class Parent{

    }

//    class Child extends Parent{ // -> Error
//
//    }

    interface Parent2{
        final double PI = 3.14;
        public abstract void abc();
    }
}
