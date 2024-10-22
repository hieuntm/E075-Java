package day6.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // Kiểm tra email
    // ten@domain
//^[a-zA-Z0-9._-]{6,32}@[a-zA-Z0-9]{2,8}\.(com|co|org|net|edu)$
    // ten: a-z, A-Z, 0-9, _, ., -, 6-32 ký tự
    // domain: a-z, A-Z, 0-9, 2-8 ký tự
    // chắc chắn domain @tổ chức .com, .co, .org
    // testttttttt@.com
    // test@com
    public static void main(String[] args) {
        String pattern = "^[IH][0-9]{7}[gX]$";
        // []: 1 trong các ký tự trong ngoặc
        // a-z, A-Z, 0-9
        // {}: lấy 7 số
        // Bắt đầu bằng I or H
        // Kết thúc bằng g or X
        // 7 ký tự số ở giữa
        Pattern pt = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        String input = "I love java . Java is interesting";
        String input2 = "Hello X";
        String input3 = "H1111111X";

//        String mau=" ^I.+g$";
        // '^' : bắt đầu chuỗi
        // '$' : kết thúc chuỗi
        // '.' : ký tự bất kỳ
        // '+' : 1 hoặc nhiều lần
        Matcher m = pt.matcher(input);
        Matcher m2 = pt.matcher(input2);
        Matcher m3 = pt.matcher(input3);

        System.out.println("Ket qua khớp:" + m.matches());
        System.out.println("Ket qua khớp:" + m2.matches());
        System.out.println("Ket qua khớp:" + m3.matches());

    }
}
