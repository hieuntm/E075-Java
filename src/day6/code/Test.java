package day6.code;

import static day6.code.Test2.abc2;

public class Test {

    // static 1 là cho biến (thuộc tính )
    // static 2 là cho function (hành vi, hàm, behavior)

    {
        System.out.println("Block 1");
    }

    static {
        System.out.println("Block 2");
    }

    public static void main(String[] args) {
        abc2();

        Test t = new Test();
        t.abc();

        xyz();
    }

    public static void xyz(){

    }

    public void abc(){

    }
}
