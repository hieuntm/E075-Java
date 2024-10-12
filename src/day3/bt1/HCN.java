package day3.bt1;

public class HCN {

    int chieuDai;
    int chieuRong;

    public HCN() {
        // default constructor
    }

    public HCN(int chieuDai) {
        // parameterized constructor
        this.chieuDai = chieuDai;
        this.chieuRong = chieuDai;
    }

    public HCN(int chieuDai, int chieuRong) {
        // parameterized constructor
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    // Nạp chồng/ Overloading
    // 1 function, cùng tên, cùng kiểu trả về, khác nhau về tham số
    // Constructor overloading

    void display(){
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
    }

    void display(int a){
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
    }

    void display(int b, int c){
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
    }

    void display(double a){
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
    }

    // Function overloading

    void chuVi(){
        System.out.println("Chu vi: " + (chieuDai + chieuRong) * 2);
    }

    int dienTich(){
        return chieuDai * chieuRong;
    }
}
