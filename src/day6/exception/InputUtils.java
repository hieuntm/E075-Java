package day6.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    // Validate, Custom, Validate Text, Date
    // Email, Password
    public static int nhapSo(int min, int max) {
        int n = -1;
        boolean flag;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhập số: ");
                n = sc.nextInt();

                if (!((n >= min) && (n <= max))) {
                    throw new InputMismatchException();
                }
                flag = true;
            } catch (InputMismatchException ex) {
                System.err.println("Nhập sai, nhập lại (" + min + " -> " + max + ")");
                flag = false;
            }
        } while (!flag);
        return n;
    }
}
