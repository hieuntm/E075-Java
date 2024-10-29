package day10.baitap.bai3trang87;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Product p1 = new Product("1", "Product 1", "Vietnam", 100);
        Product p2 = new Product("1", "Product 2", "Vietnam", 200);
        Set<Product> products = new HashSet<>();
        products.add(p1);
        products.add(p2);
        System.out.println(products);
        System.out.println(p1.equals(p2));

        // Tùng dùng SortedSet

        // List đơn thuần là array -> Bài nào dùng cũng được
        // Set chúng ta dùng khi không muốn có phần tử lặp -> Override, hashCode và equals
        // HashMap<Key, Value> -> Key -> Value

        // Không khuyến khích dùng
        // bởi vì là Sorted, mỗi khi em thêm vào nó sẽ sắp xếp lại
        // Performance
        SortedSet<Product> tung = new TreeSet<>();
        tung.add(p1);

        // TreeSet -> Tree và Set
        // Tree thì cần biết thứ tự, về bản chất cũng có orders
        // Set là unique ko phần tử trùng
        // Vương dùng TreeSet
        TreeSet<Product> vuong = new TreeSet<>();
        vuong.add(p1);

        // ArrayList, HashMap -> Dùng nhiều
    }
}
