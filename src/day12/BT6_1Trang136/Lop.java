package day12.BT6_1Trang136;

public class Lop {
    private String maLop, tenLop;
    private int siSo;

    public Lop() {
    }

    public Lop(String maLop, String tenLop, int siSo) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.siSo = siSo;
        // Nó phải tính năng thêm sinh viên vào lớp
        // Xoá sinh viên khỏi lớp
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSiSo() {
        return siSo;
    }

    public void setSiSo(int siSo) {
        this.siSo = siSo;
    }

    @Override
    public String toString() {
        return "Lop{" +
                "maLop='" + maLop + '\'' +
                ", tenLop='" + tenLop + '\'' +
                ", siSo=" + siSo +
                '}';
    }
}
