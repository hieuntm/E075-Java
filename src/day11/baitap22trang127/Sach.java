package day11.baitap22trang127;

public class Sach {
    private int maSH;
    private String tenSach;
    private String tacGia;
    private String nhaXB;
    private int namXB;

    public Sach(int maSH, String tenSach, String tacGia, String nhaXB, int namXB) {
        this.maSH = maSH;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXB = nhaXB;
        this.namXB = namXB;
    }

    public int getMaSH() {
        return maSH;
    }

    public void setMaSH(int maSH) {
        this.maSH = maSH;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }
}
