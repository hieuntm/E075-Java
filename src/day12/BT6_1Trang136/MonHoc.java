package day12.BT6_1Trang136;

public class MonHoc {
    private String maMh;
    private String tenMh;
    private int soTinChi;
    private int tinhChat;

    public MonHoc() {
        this.soTinChi = 3;
    }

    public MonHoc(String maMh, String tenMh, int soTinChi, int tinhChat) {
        this.maMh = maMh;
        this.tenMh = tenMh;
        this.soTinChi = soTinChi;
        this.tinhChat = tinhChat;
    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public int getTinhChat() {
        return tinhChat;
    }

    public void setTinhChat(int tinhChat) {
        this.tinhChat = tinhChat;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "maMh='" + maMh + '\'' +
                ", tenMh='" + tenMh + '\'' +
                ", soTinChi=" + soTinChi +
                ", tinhChat=" + tinhChat +
                '}';
    }
}
