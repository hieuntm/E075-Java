package day7.collections.list.comparator;


// Những cái class, mà ngta yêu cầu
// 1 là có thuộc tính
// 2 là constructor (default, parameterized)
// => Class dữ liệu (data class)
// B1. Tạo các thuộc tính (nên ở private)
// B2. Tạo constructor
// B3. Tạo getter, setter
// B4. Tạo toString
public class Account2 {

    private String customerName;
    private String accountNumber;
    private int accountBalance;

    public Account2() {
        // set mặc định giá trị
        // cái này fix cứng,
        // Cứ object được tạo ra bằng default constructor
        // thì các thuộc tính đều mang giá trị bên dưới
//        this.customerName = "GA";
//        this.accountNumber = "GA0001";
//        this.accountBalance = 1000;
    }

    public Account2(String customerName, String accountNumber, int accountBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    // toString cho phép in ra thông tin của object
    // System.out.println(object) -> in ra thông tin của object
    @Override
    public String toString() {
        return
                "Tên là ='" + customerName + '\'' +
                ", Số tài khoản ='" + accountNumber + '\'' +
                ", Số dư tài khoản =" + accountBalance;
    }
}
