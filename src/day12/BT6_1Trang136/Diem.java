package day12.BT6_1Trang136;

public class Diem {

    private String mssv;
    private String maMh;
    private float diem;

    public Diem() {
    }

    public Diem(String mssv, String maMh, float diem) {
        this.mssv = mssv;
        this.maMh = maMh;
        this.diem = diem;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "mssv='" + mssv + '\'' +
                ", maMh='" + maMh + '\'' +
                ", diem=" + diem +
                '}';
    }
}
