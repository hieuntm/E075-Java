package day11.baitap22trang127;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        Sach sach = new Sach(1, "Sample Book", "Author Name", "Publisher Name", 2023);
        Sach sach2 = new Sach(2, "Sample Book2", "Author Name", "Publisher Name", 2023);

        DocGia docGia = new DocGia(1, "Nguyen Van A", new Date(System.currentTimeMillis()), "0123456789", "Ha Noi");

        PhieuMuon phieuMuon = new PhieuMuon();
        phieuMuon.setMaThue(1); // tu dinh nghia
        phieuMuon.setMaDG(docGia.getMaDG());

        RefPhieuMuonSach refPhieuMuonSach = new RefPhieuMuonSach();
        refPhieuMuonSach.setMaSH(sach.getMaSH());
        refPhieuMuonSach.setMaThue(phieuMuon.getMaThue());

        RefPhieuMuonSach refPhieuMuonSach2 = new RefPhieuMuonSach();
        refPhieuMuonSach2.setMaSH(sach2.getMaSH());
        refPhieuMuonSach2.setMaThue(phieuMuon.getMaThue());

        phieuMuon.getRefPhieuMuonSachList().add(refPhieuMuonSach);
        phieuMuon.getRefPhieuMuonSachList().add(refPhieuMuonSach2);

        System.out.println(phieuMuon);

        // PhieuMuon{
        // maThue=1,
        // ngayMuon=null,
        // maDG=1,
        // refPhieuMuonSachList=
        // [
        //          RefPhieuMuonSach{maSH=1, maThue=1, ngayTra=null},
        //          RefPhieuMuonSach{maSH=2, maThue=1, ngayTra=null}
        //  ]
        //  }
    }
}
