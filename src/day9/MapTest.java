package day9;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Apple", "Táo");
        map.put("Banana", "Chuối");

        // map.keySet trả về một Set chứa tất cả các key trong map
        // map.values trả về một Collection chứa tất cả các value trong map
//        map.values();
        // apple -> nhập từ bàn phím vào
        map.get("Apple");

        for (String key : map.keySet()) {
            // Lặp từng cái key trong map
            System.out.println(key + " - " + map.get(key));
        }
    }
}
