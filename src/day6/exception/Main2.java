package day6.exception;

import java.util.InputMismatchException;

public class Main2 {
    public static void main(String[] args) throws InsufficientFundsException{
        try {
            int x = InputUtils.nhapSo(1, 10);
        } catch (InputMismatchException ex) {
            System.out.println("Bắt null");
            ex.printStackTrace();
        }


        try{
            throw new InsufficientFundsException("Số tiền trong tài khoản không đủ");
        } catch(InsufficientFundsException ex){
            System.err.println(ex.getMessage());
        }
    }
}
