package day3.bt3;

public class HinhTamGiac {

    private int ma, mb, mc;

    public HinhTamGiac() {
    }

    public HinhTamGiac(int ma, int mb, int mc) {
        this.ma = ma;
        this.mb = mb;
        this.mc = mc;

        if (!checkTamGiac()) {
            this.ma = 0;
            this.mb = 0;
            this.mc = 0;
            System.out.println("Khong phai tam giac");
            return;
        }
        if (ma <= 0) {
            this.ma = 0;
            System.out.println("Canh a phai lon hon 0");
            return;
        }
        if (mb <= 0) {
            this.mb = 0;
            System.out.println("Canh b phai lon hon 0");
            return;
        }
        if (mc <= 0) {
            this.mc = 0;
            System.out.println("Canh c phai lon hon 0");
        }
    }

    int getChuVi() {
        return ma + mb + mc;
    }

    double getDienTich() {
        double p = getChuVi() / 2.0;
        return Math.sqrt(p * (p - ma) * (p - mb) * (p - mc));
    }

    boolean checkTamGiac() {
//        boolean dk1 = ma + mb > mc;
//        boolean dk2 = ma + mc > mb;
//        boolean dk3 = mb + mc > ma;
//        boolean isTamGiac = dk1 && dk2 && dk3;
//        return isTamGiac;

        return ma + mb > mc &&
                ma + mc > mb &&
                mb + mc > ma;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        int temp = this.ma;
        this.ma = ma;
        if (!checkTamGiac()) {
            this.ma = temp;
            System.out.println("Khong phai tam giac");
        }
    }

    public int getMb() {
        return mb;
    }

    public void setMb(int mb) {
        int temp = this.mb;
        this.mb = mb;
        if (!checkTamGiac()) {
            this.mb = temp;
            System.out.println("Khong phai tam giac");
        }
    }

    public int getMc() {
        return mc;
    }

    public void setMc(int mc) {
        int temp = this.mc;
        this.mc = mc;
        if (!checkTamGiac()) {
            this.mc = temp;
            System.out.println("Khong phai tam giac");
        }
    }

    // Khi hàm này, được override thì các bạn sout  một đối tượng sẽ in ra thông tin của đối tượng đó
    public String toString() {
        return "HinhTamGiac{" +
                "ma=" + ma +
                ", mb=" + mb +
                ", mc=" + mc + ", , chuvi=" + getChuVi() + ", dientich=" + getDienTich() + "}";
    }
}
