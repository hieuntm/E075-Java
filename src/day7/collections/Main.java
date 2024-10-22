package day7.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // max size
        int x = Integer.MAX_VALUE;

        // List -> ArrayList
        // Ok
        ArrayList<Integer> a = new ArrayList<>();
        // Ok, but recommended
        List<Integer> b = new ArrayList<>();
        // Contains
        // add()
        // remove
        a.add(1); // Index 0
        a.add(2); // index 1
        a.add(3); // index 2
        a.add(10000000);
        System.out.println(a);

        int index2 = a.get(2); // a.get(index)
        System.out.println(index2);
        // trả về giá trị tại index
        // vì là trả về,
        // 1 là gán lại vào 1 biến
        // 2 là print ra
        // Set -> HashSet

        // Map -> HashMap

    }
}
