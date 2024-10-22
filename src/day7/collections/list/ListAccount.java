package day7.collections.list;

import day7.collections.list.comparator.Account2;
import day7.collections.list.comparator.AccountComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListAccount {

    public static void main(String[] args) {
        Account a = new Account("A", "A0001", 1768);
        Account a2 = new Account("B", "B0001", 345);

        // List chứa các phần tử lặp, có liên quan order
        // Trong ngược nhọn, thì không sử dụng
        // primative type: int, double, float, char, boolean, long, short, byte
        // mà phải sử dụng kiểu Wrapper/ Object: Integer, Double, Float, Character, Boolean, Long, Short, Byte
        // Hoặc là sử dụng kiểu Object: Object, String, Account, List, Map, Set
        // Hoặc là class mình tự định nghĩa ra
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        // Khởi tạo mảng có kiểu là Account
        List<Account> accounts = new ArrayList<>();
        // add(object) thêm phần tử vào mảng
        // add(index,object) - chèn phần tử vào vị trí index
        accounts.add(a);
        accounts.add(a2);

        System.out.println(accounts);

        // exception -> try/catch
//        System.out.println(accounts.get(2));
        accounts.add(0, new Account("C", "C0001", 456));

        // Sau khi add tại vị trí 0, account C
        System.out.println(accounts);

        // remove  -- Xoá
        // remove(index) -- Xoá theo index
        // remove(Object) -- Xoá theo object truyền vào
        // Cần phải biết object cần là gì, nếu mà sử dụng new thì ko baogio xoá được
        // Vậy có sự kết hợp
        // get(index) -> remove(object)
        // có index -> remove(index)
        // Xoá a
//        accounts.remove(1);
//        accounts.remove(a);
        // Sau khi xoá account a
//        System.out.println(accounts);


        // addAll() -- Cho phép thêm nhiều phần tử
        // Hoặc clone hết phần từ của mảng này sang mảng khác
        // Cách 1
        List<Account> listNew = new ArrayList<>();
        listNew.addAll(accounts);

        // Cách 2
//        List<Account> listNew2 = new ArrayList<>(accounts);

        // removeAll()
        // Ví dụ mảng A có 10 phần tử
        // Mảng B chứa 5 phần tử thuộc mảng A
        // Khi a.removeAll(B) -> Tức mảng A sẽ xoá đi toàn bộ phần tử của A mà nằm trong B
        // Còn lại 5 phần tử còn lại

        // get(index) -- Trả về phần tử tại index
        // nếu index mà lớn size thì trả về exception
        Account account = accounts.get(0);
        System.out.println(account);

        // size() -- Kích thước mảng
        int size = accounts.size();
        System.out.println("Kich thước mảng: " + size);

        // contains(Object) - Chứa
        // Trả về true nếu mảng chứa object
        // Trả về false nếu mảng không chứa object
        boolean contains = accounts.contains(new Account("D", "D0001", 1000));
        System.out.println(contains);

        // indexOf(Object) - Trả về index của object
        // Nếu không có thì trả về -1
        int index = accounts.indexOf(new Account("D", "D0001", 1000));
        System.out.println(index);

        // a là object Account A
        // a2 là object account B
        int indexA = accounts.indexOf(a2);
        System.out.println(a2 + " tại vị trí: "+ indexA);

        // set(index, object) - Thay thế object tại index
        // Thay thế object tại index 0 bằng object account D
        // ít dùng
//        accounts.set(0, new Account("D", "D0001", 1000));

        // clear -> Xoá toàn bộ phần tử trong mảng
//        accounts.clear();

        // isEmpty() - Kiểm tra mảng có rỗng không
        // Trả về true nếu mảng rỗng
        // Trả về false nếu mảng không rỗng
        // * Hay dùng
        boolean isEmpty = accounts.isEmpty();
        System.out.println(isEmpty);

        // Cách 1
        for(int i = 0; i < accounts.size(); i++) {
            // get(index) -> Trả về object tại index
            // Mà index lại chạy từ 0 -> size - 1
            Account account1 = accounts.get(i);
            // comment sout
//            System.out.println("Cách 1: " + account1);
        }
        // Cách 2
        for(Account accountDisplay: accounts) {
            // Nó sẽ tự hiểu là accountDisplay
            // nó sẽ chạy từ đầu đến cuối mảng
//            System.out.println("Cách 2: " + accountDisplay);
        }

        // Cách 3
        accounts.forEach(accountDisplay -> {
            // Nó sẽ chạy từ đầu đến cuối mảng
            // accountDisplay là object
            // -> là phần thân của method
            // Nếu có nhiều dòng thì phải có {}
            System.out.println("Cách 3: " + accountDisplay);
        });

        // sorts
        // Thì cần phải implements Comparator
        // Khai báo class mới và implements Comparator
        // Override function compare
        // So sánh 2 object
        // logic rõ ràng hơn
//        Account2 != Account
        List<Account2> accounts2 = new ArrayList<>();

        accounts2.add(new Account2("A", "A0001", 1768));
        accounts2.add(new Account2("B", "B0001", 345));
        accounts2.add(new Account2("C", "C0001", 456));
        accounts2.sort(new AccountComparator());
        System.out.println(accounts2);

        // Nếu muốn dùng Collections.sort(list)
        // Thì cái object mà list chứa
        // Thì cần phải implements Comparable
        // Sau khi implement Comparable thì cần phải override function compareTo
        // xử lý so sánh 2 object
        // So sánh this với object truyền về
        // Compare được 1 trường dữ liệu
        // Nếu muốn so sánh nhiều hơn 2 trường thì cần phải if else nhiều, logic phức tạp
        // Implements
        Collections.sort(accounts);

        System.out.println(accounts);
    }

}
