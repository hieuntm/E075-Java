package day11.baitap22trang127;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuon {
    private int maThue;
    private Date ngayMuon;
    private int maDG;
    private List<RefPhieuMuonSach> refPhieuMuonSachList = new ArrayList<>();

    public int getMaThue() {
        return maThue;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }

    public List<RefPhieuMuonSach> getRefPhieuMuonSachList() {
        return refPhieuMuonSachList;
    }

    public void setRefPhieuMuonSachList(List<RefPhieuMuonSach> refPhieuMuonSachList) {
        this.refPhieuMuonSachList = refPhieuMuonSachList;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" +
                "maThue=" + maThue +
                ", ngayMuon=" + ngayMuon +
                ", maDG=" + maDG +
                ", refPhieuMuonSachList=" + refPhieuMuonSachList +
                '}';
    }
}
