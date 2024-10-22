package day7.bai1trang74;

import java.util.Arrays;
import java.util.Scanner;

public class Bank {

    //    private int accList[]; // Array of int
    private Account accList[]; // Array of Account
    private final int accMax; // số lượng account tối đa mảng có thể chứa
    private int nextAccount; // Là index để nó kiểm tra xem là mảng đã đủ

    // Khi mà dùng new Bank() -> Các thuộc tính nó sẽ được khởi tạo bên trong body của
    // default constructor
    public Bank() {
        // setup mặc định
        this.accMax = 2;
        this.accList = new Account[accMax];
        this.nextAccount = 0;
    }

    public void createAccount() {
        // Nhập thông tin cần tạo account -> Name, Number, Balance
        // Tạo 1 account
        // Nhét vào mảng
        // Khi nhét, chúng ta có nextAccount, để kiểm tra index
        // 1 điều kiện là nếu balance < 100, thì mình throw exception, và truyền message vào đấy
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập tên: ");
            String name = sc.nextLine();
            System.out.println("Nhập account number: ");
            String number = sc.nextLine();
            System.out.println("Nhập số dư tài khoản: ");
            int balance = sc.nextInt();
            // Kiểm tra balance
            if (balance < 100) {
                // Nếu điều kiện đúng, thì exception nó tạo ra và nó nhảy trực tiếp sang hàm catch
                throw new InsufficientFundsException("Số dư nhỏ 100");
            }
            // Nếu expcetion không xảy thì mới thực hiện tiếp
            // ------
            // Pass
            int tim = 0;
            for (int i = 0; i < nextAccount; i++) {
                if (accList[i].getAccountNumber().equals(number)) {
                    tim = 1;
                    break;
                }
            }
            if (tim == 1) {
                throw new InsufficientFundsException("Tài khoản đã tồn tại");
            }
            Account a = new Account(name, number, balance);
            if (nextAccount < accMax) {
                accList[nextAccount] = a;
                nextAccount++;

                System.out.println("Account tạo thành công");
                System.out.println("Thông tin account");
                System.out.println(a);
            } else {
                System.out.println("Không thể tạo thêm account, tối đa là: " + accMax + " account(s)");
            }
        } catch (InsufficientFundsException e) {
            // -> Nhảy vào đây
            System.err.println(e.getMessage());
        }
    }

    public void displayAccountDetails(Account account) {
        // Cách 1: Với toString
//        System.out.println(account);

        // Cách 2: In ra từng thuộc tính và không cần định nghĩa/Override toString
        System.out.println("Tên: " + account.getCustomerName());
        System.out.println("Số tài khoản: " + account.getAccountNumber());
        System.out.println("Số dư tài khoản: " + account.getAccountBalance());
    }

    // Nạp tiền
    public void deposite() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập vào số tài khoản : ");
            String soTaiKhoan = sc.nextLine();
            System.out.println("Nhập vào số tiền cần gửi: ");
            int soTienGui = sc.nextInt();
            int tim = 0;
            for (int i = 0; i < nextAccount; i++) {
                if (accList[i].getAccountNumber().equals(soTaiKhoan)) {
                    tim = 1;
                    // accList[i].getAccountBalance()
                    // Trả về Account ở vị trí i
                    // dùng function getAccountBalance trả về số dư của Account tại vị trí i
                    if(soTienGui < 0){
                        throw new InsufficientFundsException("Số tiền gửi phải lớn hơn 0");
                    }
                    int soDuMoi = accList[i].getAccountBalance() + soTienGui;
                    accList[i].setAccountBalance(soDuMoi);
                    displayAccountDetails(accList[i]);
                    break;
                }
            }
            if (tim == 0) {
                throw new InsufficientFundsException("Không tìm thấy tài khoản");
            }
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }
    }

    // Rút tiền
    public void draw() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập vào số tài khoản : ");
            String soTaiKhoan = sc.nextLine();
            System.out.println("Nhập vào số tiền cần rút: ");
            int soTienRut = sc.nextInt();
            int tim = 0;
            for (int i = 0; i < nextAccount; i++) {
                if (accList[i].getAccountNumber().equals(soTaiKhoan)) {
                    tim = 1;
                    // accList[i].getAccountBalance()
                    // Trả về Account ở vị trí i
                    // dùng function getAccountBalance trả về số dư của Account tại vị trí i
                    int soDuHienTai = accList[i].getAccountBalance();
                    if(soTienRut < 0){
                        throw new InsufficientFundsException("Không rút được số âm");
                    }
                    if(soTienRut > soDuHienTai){
                        throw new InsufficientFundsException("Số dư không đủ");
                    }
                    // Passs hết điều kiện
                    int soDuMoi = soDuHienTai - soTienRut;
                    accList[i].setAccountBalance(soDuMoi);
                    displayAccountDetails(accList[i]);
                    break;
                }
            }
            if (tim == 0) {
                throw new InsufficientFundsException("Không tìm thấy tài khoản");
            }
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
