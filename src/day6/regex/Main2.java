package day6.regex;

public class Main2 {

    public static void main(String[] args) {
        String test = "HIEOO XXX       ABCC, 123312 ,,,,        23432432";
        String[] arr = test.split(" ");
        for (String s : arr) {
            System.out.println(s + "-"+ s.length());
        }
    }
}
