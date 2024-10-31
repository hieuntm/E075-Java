package day11.baitap22trang127;

import java.sql.Date;

public class RefPhieuMuonSach {
    private int maSH;
    private int maThue;
    private Date ngayTra;

    public int getMaSH() {
        return maSH;
    }

    public void setMaSH(int maSH) {
        this.maSH = maSH;
    }

    public int getMaThue() {
        return maThue;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    @Override
    public String toString() {
        return "RefPhieuMuonSach{" +
                "maSH=" + maSH +
                ", maThue=" + maThue +
                ", ngayTra=" + ngayTra +
                '}';
    }
}
