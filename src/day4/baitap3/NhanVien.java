package day4.baitap3;

public class NhanVien {

    private String maNV;
    private int soSP;

    public NhanVien() {
    }

    public NhanVien(String maNV, int soSP) {
        this.maNV = maNV;
        this.soSP = soSP;
    }

    // Ten thuoc tinh, viet hoa chu dau len
    // no vao dau get or set

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSoSP() {
        return soSP;
    }

    public void setSoSP(int soSP) {
// Cach 1
//        if(soSP > 0){
//            this.soSP = soSP;
//        } else {
//            this.soSP = 0;
//        }
// Cach 2
        this.soSP = soSP > 0 ? soSP : 0;
// Cach 3
//        this.soSP = Math.max(soSP, 0);
    }

    boolean coVuotChuan() {
//
//        if(this.soSP > 500){
//            return true;
//        }
//        return false;

        return this.soSP > 500;
    }

    String getTongKet() {
//        if(coVuotChuan()){
//            return "Vuot";
//        }
//        return "";

        return coVuotChuan() ? "Vuot" : "";
    }

    double getLuong() {
        // 1 san pham = 20k
        // net vuot chuan, 1 san pham = 30k;
//        if(coVuotChuan()){
//            return this.soSP * 30_000;
//        }
//
//        return this.soSP * 20_000;

        // Logic 2: Chi tinh so sp vuot chuan
        // Tinh ra so luong san pham vuot chuan
        if (coVuotChuan()) {
            int soSPVuotChuan = this.soSP - 500;
            return 500 * 20_000 + soSPVuotChuan * 30_000;
            // Dung het code o duoi
        }
        //
        return this.soSP * 20_000;
    }

    @Override
    // BIen object -> String
    public String toString() {
        return String.format("%10s %5d %6s %10.2f", this.maNV, this.soSP, getTongKet(), getLuong());
    }
}
