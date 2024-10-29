package day9;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        TreeSet<String> set2 = new TreeSet<>();
        // ko order
        // ko duplicate
        set2.add("Apple");
        set2.add("Apple");

        System.out.println(set2);

        set.add("Apple");
        set.add("Banana");
//        Product p

        String found = "";
        for(String s : set) {
            if(s.equals("Bannana")){
                found = s;
                break;
            }
        }
        set.remove(found);
    }
}
