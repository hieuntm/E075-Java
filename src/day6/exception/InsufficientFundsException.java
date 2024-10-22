package day6.exception;

// Để đảm bảo số tiền trong account nó hợp lý
// Tức là ko nhỏ hơn 0
public class InsufficientFundsException extends Exception{

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException() {
    }


}
