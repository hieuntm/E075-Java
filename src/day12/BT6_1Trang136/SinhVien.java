package day12.BT6_1Trang136;

import java.sql.Date;


// Ở trong database, thì tên cột có thể viết hoa
// Ở trong Java, thì tên thuộc tính không nên viết hoa
public class SinhVien {

    private String mssv;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private String maLop;
    private String gioiTinh;

    public SinhVien() {
    }

    public SinhVien(String mssv, String hoTen, Date ngaySinh, String diaChi, String maLop, String gioiTinh) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.maLop = maLop;
        this.gioiTinh = gioiTinh;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", maLop='" + maLop + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }
}
