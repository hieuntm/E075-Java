package day3;

public class Terrorist {

    // Thuộc tính
    String name;
    double hp;
    double speed;

    // Behavior

    // Mac dinh, neu khong co constructor
    // Thi constructor default se tu dong co
    public Terrorist() {
        // Constructor default
        // Khoi tao 1 object trắng, rỗng
    }

    // Neu tao constructor ko phai default
    // Thi constructor bi disable

    // Cách 1
//    public Terrorist(String nameParam, double hpParam, double speedParam){
//        // Constructor có tham số
//        // dùng các tham số từ ngoài để khởi tạo object
//        name = nameParam;
//        hp = hpParam;
//        speed = speedParam;
//    }

    // Cách 1
    public Terrorist(String name, double hp, double speed) {
        // Constructor có tham số
        // dùng các tham số từ ngoài để khởi tạo object
        this.name = name;
        this.hp = hp;
        this.speed = speed;
    }

    // Hàm toString là hàm mặc định được kế thừa lại
//    public String toString(){
//        return this.name + "/hp: " + this.hp + "/speed: " + this.speed;
//    }
    // Ko phai la toString mặc định được kế thừa mà là 1
    // hành vi được định nghĩa
    // Là hàm
    public String tostring() {
//        return this.name + "/hp: " + this.hp + "/speed: " + this.speed;
        return String.format("%20s - %3f - %3f", this.name, this.hp, this.speed);
    }
}
