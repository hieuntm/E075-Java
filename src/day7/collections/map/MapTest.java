package day7.collections.map;

import day7.collections.list.Account;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // Bản đồ, chỉ dẫn
        // Tức là có bản đồ kho báu -> Tìm được kho báu
        // Bản đồ này có 2 thành phần: key và value
        // Key: là định danh, là duy nhất
        // Ko theo order
        // Map<Key, Value>
        Map<String, String> map = new HashMap<>();
        Map<String, Account> mapAccount = new HashMap<>();
        Map<String, Account[]> mapAccount2 = new HashMap<>();
        Map<String, Map<String, Account[]>> mapAccount3 = new HashMap<>();

        map.put("name", "Nguyen Van A");
        map.put("age", "20");
        map.put("address", "Ha Noi");

        // Nó cũng sẽ chứa 1 số function như list, set
        // Tuy nhiên
        // Đối với add
        // thì map dùng put
        // đối với remove
        // thì map dùng remove

        // Việc lấy dữ liệu, thay vì get(index)
        // get(key)
        System.out.println(map.get("name"));
        map.put("name", "Nguyen Van B");
        System.out.println(map.get("name"));

        // Xóa dữ liệu
        // Xoá key
        map.remove("name");

        // Xoá toàn bộ
//        map.clear();

        // Kiểm tra xem map có chứa key đó không
        System.out.println(map.containsKey("name"));
        System.out.println(map.get("name") == null);

        // size
        System.out.println(map.size());

        // isEmpty -> Kiểm tra xem map có rỗng không
        // if size > 0 -> false
        // if size = 0 -> true
        System.out.println(map.isEmpty());

        // loop
        for (String key : map.keySet()) {
            // Lặp từng cái key trong map
            System.out.println(key + " - " + map.get(key));
        }

        // loop 2
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // Lặp từng cặp key - value trong map
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
}
