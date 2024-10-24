package day8.collection.review;

import java.util.ArrayList;
import java.util.List;

public class ListMain {

    public static void main(String[] args) {

        // List size vô tận -> giới hạn bởi 2 tỷ 147 triệu 483 nghìn 647 = 2^31 - 1
        // List khi các bạn khởi tạo, mặc định size của nó chỉ là 10
        // Khi mà các bạn add vào, nó vượt quá size, nó tự động resize lên 1.5 lần size cũ
        // List chứa phần tử lặp, Và theo thứ tự
        // Set không chứa phần tử lặp, không theo thứ tự
        List<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        // add(object), add(index, object)
        // remove(index), remove(object)
        // get(index)
        // size() -> trả về kích thước mảng
        // isEmpty() -> kiểm tra mảng có rỗng không
        // clear() -> Xoá toàn bộ


    }
}
