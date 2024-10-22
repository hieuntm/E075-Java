package day7.collections.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // Set giống y nguyên list
        // tuy nhiên nó không cho phép có phần tử trùng
        // Nó sẽ thêm phần tử không theo thứ tự
        // Order -> ngẫu nhiên
        set.add("C#");
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java");

        System.out.println(set);

        List<String> list = List.of("C#", "Java", "Python", "C++", "Java");
        // Cách 2 trong việc addAll()
//        Set<String> set2 = new HashSet<>(list);
        // Cách 1
        Set<String> set2 = new HashSet<>();
        set2.addAll(list);
        System.out.println(set2);
    }
}
