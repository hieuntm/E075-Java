package day6.exception;


public class Test {

    // Có biến x
    // dùng sc nhập vào
    // Bài toán: Chỉ người dùng nhập vào 1 số
    // thì chương trình mới tiếp tục chạy
    // Nếu người dùng nhập ký thì thông báo lỗi, và bắt người dùng nhập lại

    public static void main(String[] args) {
        try {
            test();
        } catch (NullPointerException x) {
            // Bắt lỗi
            // Bắt xong thì chương trình chạy tiếp
            System.out.println("Bắt null");
            x.printStackTrace();
        } catch (ArithmeticException ex) {
            System.out.println("Bắt chia cho 0");
            ex.printStackTrace();
        } catch(Exception exception){
            System.out.println("Bắt lỗi chung");
            exception.printStackTrace();
        }

        System.out.println("Pass error");
        System.out.println("Pass ABCCC");


        // Có đến hàng tỷ các lỗi khác nhau
        // Chia ra thành 2 loại
        // 1. Checked Exception -- Compile time exception - Lỗi xảy ra khi compile
        // 2. Unchecked Exception -- Run time exception  - Trong quá trình run, thì phát sinh lỗi
    }

    public static int test() {
//        int x = 10  -> Thiếu dấu ; là compile time -> Lỗi check cú pháp
        int x = 1 / 0; // - > Run time exception -> phải chạy thì mới ra lỗi
        // Giả sử,
        // Người dùng nhập 1 và 0
        // Rồi gọi function chia/ divide
        // Người dùng upload file chứa dữ liệu 1 và 0
        // GỌi function chia
        return 1;
    }

    public String test2(int y) {
        String s;
        if (y > 10) {
            s = "Lớn hơn 10";
        } // Điều kiện nó không cover hết trường hợp
        // thằng s có thể không được gán gía trị
        // Phải có giá trị null, hoặc phải có giá trị khởi tạo

        if (y < 10) {
            s = "Nhỏ hơn 10";
        } else {
            s = "Bằng 10";
        }
        return s;
    }
}
