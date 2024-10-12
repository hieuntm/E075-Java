package day3.bt1;

public class HCN {

    int chieuDai;
    int chieuRong;

    public HCN() {
        // default constructor
    }

    public HCN(int chieuDai, int chieuRong) {
        // parameterized constructor
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    void display(){
        System.out.println("Chiều dài: " + chieuDai);
        System.out.println("Chiều rộng: " + chieuRong);
    }

    void chuVi(){
        System.out.println("Chu vi: " + (chieuDai + chieuRong) * 2);
    }

    int dienTich(){
        return chieuDai * chieuRong;
    }
}
