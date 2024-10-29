package day10.generics;

// ví dụ 5 bộ mã gen
// Khong dùng nhiều như này đâu
// Tối đa, 2 bộ mã gen là đủ
public class GeneMath<T> {

    // Dùng T ở trên class
    // Để định nghĩa ra các funtion
    // hoặc thuộc tính

    // Tạo 2 biến
    // Có kiểu T, kiểu T được lấy từ
    // <> khi mà khởi tạo object
    private T number1;
    private T number2;

    // Dùng T làm kiểu dữ liệu ko bắt buộc

    public String toString(){
        return "Number 1: " + number1 + ", Number 2: " + number2;
    }

    public boolean compare(){
        return number1 == number2;
    }

    public T add(){
        // T ko rõ kiểu, nên cần phải ép kiểu
        if(number1 instanceof Integer){
            return (T) Integer.valueOf((Integer) number1 + (Integer) number2);
        }
        if(number1 instanceof Double){
            return (T) Double.valueOf((Double) number1 + (Double) number2);
        }
        if(number1 instanceof String){
            String s1 = (String) number1;
            String s2 = (String) number2;
            // Cộng chuỗi, concat
            return (T) (s1 + s2);
        }
        // Nếu không phải 1 trong 3 kiểu này thì return null
        return null;
    }

    public GeneMath(T number1, T number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public T getNumber1() {
        return number1;
    }

    public void setNumber1(T number1) {
        this.number1 = number1;
    }

    public T getNumber2() {
        return number2;
    }

    public void setNumber2(T number2) {
        this.number2 = number2;
    }
}
