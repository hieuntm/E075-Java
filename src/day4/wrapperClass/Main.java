package day4.wrapperClass;

public class Main {

    boolean a; // false
    byte b; // 0
    short c; // 0
    int d; // 0
    long e; // 0.0
    float f; // 0.0
    double g; // 0.0
    char h; // ''
    // Primitive data types;
    // Ung voi cac kieu du lieu nguyen thuy, Java cung cap cac lop doi tuong tuong ung

    // Wrapper class
    Boolean aA;
    Byte bB;
    Short cC;
    Integer dD;
    Long eE;
    Float fF;
    Double gG;
    Character hH;
    // La Class => Gia tri mac dinh cua no la null

    public static void main(String[] args) {
        int x = 0;
        Integer y = null;
        System.out.println(x +"---"+ y);

        String string = "";
        string = "abc";
        string = string.toUpperCase(); // => ABC

        string = "XYZ";

        Long xxx = 10L; // long
        Double yyy = 20D; // double => Double
        Boolean zzz = Boolean.FALSE;
        //deprecated
//        Boolean zzz2 = new Boolean(false);


        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        sb.toString().toUpperCase();
        // Concat,
        // SubString
        System.gc();
        // Co goi thi cung khong chac la di gom rac.


        Math.abs(-10);
        Math.min(10, 20); // => 10
        Math.max(10, 20); // => 20
        Math.sqrt(64); // => 8
        Math.pow(2, 3); // => 8
        double random1 = Math.random() * 100 + 1; // => 0.0 -> 1.0 => float, long, double
        // (int) (double) (float) (long) (short) (byte)
//        int cast = Integer.parseInt(random1+"");

        System.out.println(random1);
        System.err.println("ABCCCCCCC");

        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.class.version"));
        System.out.println(System.getProperty("java.specification.vendor"));
        System.out.println(System.getProperty("java.specification.version"));
        System.out.println(System.getProperty("java.vendor"));
        System.out.println(System.getProperty("java.vendor.url"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.vm.name"));

        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("calc.exe");
        }
        catch(Exception e){
            System.out.println("Error executing calculator");
        }
    }

    // CharSequence
    // String, StringBuilder, StringBuffer
    // String la immutable
    // StringBuilder, StringBuffer la mutable
    // StringBuffer -> Dong bo -> An toan nhung ma performance thap
    // String Builder -> Bat dong bo -> Khong an toan nhung ma performance cao
}
